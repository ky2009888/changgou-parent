package org.changgou.service.file.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/9
 * @author Lenovo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FastDfsFile implements Serializable {
    /**
     * 文件名字
     */
    private String name;
    /**
     * 文件内容
     */
    private byte[] content;
    /**
     * 文件扩展名
     */
    private String ext;
    /**
     * 文件MD5摘要值
     */
    private String md5;
    /**
     * 文件创建作者
     */
    private String author;

    public FastDfsFile(String name, byte[] content, String ext, String height,
                       String width, String author) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.author = author;
    }

    public FastDfsFile(String name, byte[] content, String ext) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
    }

}
