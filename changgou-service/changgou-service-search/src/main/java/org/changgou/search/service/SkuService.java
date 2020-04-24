package org.changgou.search.service;

import java.util.Map;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/23
 *
 * @author Lenovo
 */
public interface SkuService {
    /**
     * 根据条件进行搜索
     *
     * @param searchParamMap 搜索条件map.
     * @return Map<String, Object>
     */
    Map<String, Object> search(Map<String, Object> searchParamMap);

    /**
     * 将Sku的数据导入到索引库.
     */
    void importSkuDataToDB();
}
