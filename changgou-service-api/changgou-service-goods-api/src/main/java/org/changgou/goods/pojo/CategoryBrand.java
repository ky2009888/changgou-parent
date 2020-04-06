package org.changgou.goods.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lenovo
 */
@Table(name = "tb_category_brand")
@Data
public class CategoryBrand {
    /**
     * 分类id
     */
    @Id
    private Integer categoryId;
    /**
     * 品牌id
     */
    @Id
    private Integer brandId;
}
