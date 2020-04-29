package org.changgou;

import lombok.extern.slf4j.Slf4j;
import org.changgou.code.build.TemplateBuilder;

/****
 * @Author:ky2009888
 * @Description:
 * @Date 2019/6/14 23:43
 *****/
@Slf4j
public class CodeApplication {
    /**
     * 主入口方法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        log.info("生成代码开始");
        //调用该方法即可
        TemplateBuilder.builder();
        log.info("生成代码结束");
    }
}
