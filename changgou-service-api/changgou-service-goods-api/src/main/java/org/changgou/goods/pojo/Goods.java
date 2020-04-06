package org.changgou.goods.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author Lenovo
 */
@Data
public class Goods {
    /**
     * spu
     */
    private Spu spu;
    /**
     * sku集合
     */
    private List<Sku> skuList;
}
