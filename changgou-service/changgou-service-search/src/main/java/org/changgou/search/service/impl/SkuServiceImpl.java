package org.changgou.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.changgou.utils.Result;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.changgou.goods.feign.SkuFeign;
import org.changgou.search.dao.SkuEsMapper;
import org.changgou.search.pojo.SkuInfo;
import org.changgou.search.service.SkuService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/23
 *
 * @author Lenovo
 */
@Service("skuService")
@Slf4j
public class SkuServiceImpl implements SkuService {
    /**
     * 定义restTemplate句柄.
     */
    @Resource
    private RestTemplate restTemplate;
    /**
     * 将SkuFeign的实例注入一下.
     */
    @Resource
    private SkuFeign skuFeign;
    /**
     * 将SkuEsMapper实例注入一下.
     */
    @Resource
    private SkuEsMapper skuEsMapper;
    /**
     * 定义elasticsearchTemplate的句柄.
     */
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 根据条件进行搜索
     *
     * @param searchParamMap 搜索条件map.
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> search(Map<String, String> searchParamMap) {
        Map<String, Object> resultMap = new HashMap<>();
        if (searchParamMap == null) {
            return null;
        }
        String keyWords = searchParamMap.get("keyWords");
        if (StringUtils.isEmpty(keyWords)) {
            return null;
        }
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(QueryBuilders.queryStringQuery(keyWords).field("name"));
        AggregatedPage<SkuInfo> page = elasticsearchTemplate.queryForPage(builder.build(), SkuInfo.class);
        //总的记录数量
        long totalRecords = page.getTotalElements();
        //总的页数
        long totalPage = page.getTotalPages();
        //总的内容
        List<SkuInfo> skuInfoList = page.getContent();
        resultMap.put("totalRecords", totalRecords);
        resultMap.put("totalPage", totalPage);
        resultMap.put("skuInfoList", skuInfoList);
        queryCategoryNameByGroup(resultMap, builder);
        return resultMap;
    }

    /**
     * 进行分组查询
     *
     * @param resultMap 结果存放map
     * @param builder   查询构建对象
     */
    private void queryCategoryNameByGroup(Map<String, Object> resultMap, NativeSearchQueryBuilder builder) {
        //分组查询分类集合,terms里面的内容是取别名
        builder.addAggregation(AggregationBuilders.terms("categoryNameGroup").field("categoryName"));
        AggregatedPage aggregatedPage = elasticsearchTemplate.queryForPage(builder.build(), SkuInfo.class);
        //获取聚合数据集合
        StringTerms categoryNameGroup = aggregatedPage.getAggregations().get("categoryNameGroup");
        List<String> categoryNameList = new ArrayList<>();
        for (StringTerms.Bucket bucket : categoryNameGroup.getBuckets()
        ) {
            String categoryName = bucket.getKeyAsString();
            categoryNameList.add(categoryName);
        }
        resultMap.put("categoryNameList", categoryNameList);
    }

    /**
     * 将Sku的数据导入到索引库.
     */
    @Override
    public void importSkuDataToDB() {
        URI uri = null;
        try {
            uri = new URI("http://localhost:18081/sku/search/1/10000");
        } catch (Exception e) {
            log.error("exception:{}", e.getMessage());
        }
        ResponseEntity<Result> forEntity = restTemplate.getForEntity(uri, Result.class);
        Result<PageInfo> skuResult = forEntity.getBody();
        PageInfo pageInfo = JSON.parseObject(JSON.toJSONString(skuResult.getData()), PageInfo.class);
        List list = pageInfo.getList();
        List<SkuInfo> skuInfoList = JSON.parseArray(JSON.toJSONString(list), SkuInfo.class);
        skuEsMapper.saveAll(skuInfoList);
    }
}
