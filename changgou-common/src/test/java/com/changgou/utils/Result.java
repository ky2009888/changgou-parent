package com.changgou.utils;

/**
 * 功能描述:返回结果实体类
 * 项目名称:changgou-common
 * 创建日期:2020/4/6
 *
 * @author Lenovo
 */
public class Result<T> {
    /**
     * 是否成功
     */
    private boolean flag;
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回消息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 结果构造函数
     *
     * @param flag    是否成功
     * @param code    返回码
     * @param message 返回消息
     * @param data    返回数据
     */
    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = (T) data;
    }
    /**
     * 结果构造函数
     *
     * @param flag    是否成功
     * @param code    返回码
     * @param message 返回消息
     */
    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
    /**
     * 结果构造函数
     *
     */
    public Result() {
        this.flag = true;
        this.code = StatusCode.OK;
        this.message = "执行成功";
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
