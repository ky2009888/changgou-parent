package org.changgou.search;

import lombok.extern.slf4j.Slf4j;

import java.net.URI;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/24
 */
@Slf4j
public class TestIf {
    public static void main(String[] args) {
        int flag1 = 2;
        int flag2 = 2;
        int flag3 = 3;
        int flag4 = 4;
        int flag5 = 5;
        if (flag1 != 1) {
            log.info("flag1={}", flag1);
        } else if (flag2 == 2) {
            log.info("flag2={}", flag2);
        } else if (flag3 == 3) {
            log.info("flag3={}", flag3);
        } else if (flag4 == 4) {
            log.info("flag4={}", flag4);
        } else if (flag5 == 5) {
            log.info("flag5={}", flag5);
        }
        log.info("执行完毕");
    }
}
