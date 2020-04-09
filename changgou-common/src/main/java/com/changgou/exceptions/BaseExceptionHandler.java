package com.changgou.exceptions;

import com.changgou.utils.Result;
import com.changgou.utils.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能描述:@ControllerAdvice注解，全局捕获异常类，只要作用在@RequestMapping上，所有的异常都会被捕获。
 * 项目名称:changgou-parent
 * 创建日期:2020/4/9
 *
 * @author Lenovo
 */
@ControllerAdvice
public class BaseExceptionHandler {
    /***
     * 异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
