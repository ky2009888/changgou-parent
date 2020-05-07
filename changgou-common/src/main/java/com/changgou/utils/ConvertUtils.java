package com.changgou.utils;

import cn.hutool.core.io.IoUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * 转换工具类
 */
public class ConvertUtils {
    /**
     * 输入流转换为xml字符串
     *
     * @param inputStream
     * @return
     */
    public static String convertToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inputStream.close();
        String result = new String(outSteam.toByteArray(), StandardCharsets.UTF_8);
        return result;
    }

    /**
     * 读取流中的内容
     *
     * @param inputStream 输入流
     * @return String
     * @throws IOException
     */
    public static String convertToStringByIoUtils(InputStream inputStream) throws IOException {
        String result = IoUtil.read(inputStream, "utf-8");
        inputStream.close();
        return result;
    }
}
