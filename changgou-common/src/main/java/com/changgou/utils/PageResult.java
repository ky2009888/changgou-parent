package com.changgou.utils;

import java.util.List;

/**
 * 功能描述:分页结果
 * 项目名称:changgou-common
 * 创建日期:2020/4/6
 *
 * @author Lenovo
 */
public class PageResult<T> {
    /**
     * 总记录数
     */
    private Long total;
    /**
     * 记录
     */
    private List<T> rows;

    /**
     * 分页结果
     *
     * @param total 总记录
     * @param rows  总行数
     */
    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    /**
     * 分页结果
     */
    public PageResult() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
