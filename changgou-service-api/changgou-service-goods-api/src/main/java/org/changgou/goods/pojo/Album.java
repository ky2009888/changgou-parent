package org.changgou.goods.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * album实体类
 *
 * @author Lenovo
 */
@Table(name = "tb_album")
@Data
public class Album implements Serializable {
    /**
     * 编号
     */
    @Id
    private Long id;
    /**
     * 相册名称
     */
    private String title;
    /**
     * 相册封面
     */
    private String image;
    /**
     * 图片列表
     */
    private String imageItems;
}
