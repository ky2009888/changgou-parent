package org.changgou.search.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.io.Serializable;
import java.util.Map;

/**
 * 商品表(SkuInfo)实体类
 *
 * @author ky2009666
 * @since 2020-04-20 21:35:08
 */
@Data
@Document(indexName = "skuinfo", type = "docs")
public class SkuInfo implements Serializable {
    private static final long serialVersionUID = -39165077094087919L;
    /**
     * 商品id
     */
    @Id
    private String id;
    /**
     * 商品条码
     */
    private String sn;
    /**
     * SKU名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_smart", index = true, store = false, searchAnalyzer = "ik_smart")
    private String name;
    /**
     * 价格（分）
     */
    @Field(type = FieldType.Integer)
    private Integer price;
    /**
     * 库存数量
     */
    private Integer num;
    /**
     * 库存预警数量
     */
    private Integer alertNum;
    /**
     * 商品图片
     */
    private String image;
    /**
     * 商品图片列表
     */
    private String images;
    /**
     * 重量（克）
     */
    private Integer weight;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * SPUID
     */
    private String spuId;
    /**
     * 类目ID
     */
    private Integer categoryId;
    /**
     * 类目名称
     * FieldType.Keyword 表示不分词
     */
    @Field(type = FieldType.Keyword)
    private String categoryName;
    /**
     * 品牌名称
     */
    @Field(type = FieldType.Keyword)
    private String brandName;
    /**
     * 规格
     */
    private String spec;
    /**
     * 销量
     */
    private Integer saleNum;
    /**
     * 评论数
     */
    private Integer commentNum;
    /**
     * 商品状态 1-正常，2-下架，3-删除
     */
    private String status;
    private Integer version;
    /**
     * 规则参数
     */
    private Map<String, Object> specMap;

}