package org.changgou.search.dao;

import org.changgou.search.pojo.SkuInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/23
 */
@Repository
public interface SkuEsMapper extends ElasticsearchRepository<SkuInfo, String> {

}
