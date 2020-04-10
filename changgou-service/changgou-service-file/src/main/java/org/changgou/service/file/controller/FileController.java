package org.changgou.service.file.controller;

import org.changgou.service.file.po.FastDfsFile;
import org.changgou.service.file.util.FastDfsClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/9
 *
 * @author Lenovo
 */
@RestController
@CrossOrigin
@RequestMapping("file")
public class FileController {
    /**
     * 上传文件
     *
     * @param file 上传的文件
     * @return path 文件访问路径
     */
    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        String path = "";
        try {
            path = saveFile(file);
            System.out.println(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 文件上传的具体操作
     *
     * @param multipartFile 文件操作对象
     * @return path 文件名
     * @throws IOException
     */
    public String saveFile(MultipartFile multipartFile) throws IOException {
        //1. 获取文件名
        String fileName = multipartFile.getOriginalFilename();
        //2. 获取文件内容
        byte[] content = multipartFile.getBytes();
        //3. 获取文件扩展名
        String ext = "";
        if (fileName != null && !"".equals(fileName)) {
            ext = fileName.substring(fileName.lastIndexOf(".")+1);
        } else {
            return "";
        }
        //4. 创建文件实体类对象
        FastDfsFile fastDFSFile = new FastDfsFile(fileName, content, ext);
        //5. 上传
        String[] uploadResults = FastDfsClient.upload(fastDFSFile);
        //6. 拼接上传后的文件的完整路径和名字, uploadResults[0]为组名, uploadResults[1]为文件名称和路径
        StringBuilder pathBuilder = new StringBuilder(FastDfsClient.getTrackerUrl());
        pathBuilder.append(uploadResults[0]).append("/").append(uploadResults[1]);
        //7. 返回
        return pathBuilder.toString();
    }
}
