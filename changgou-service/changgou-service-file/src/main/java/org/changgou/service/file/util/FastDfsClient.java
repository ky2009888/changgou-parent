package org.changgou.service.file.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.changgou.service.file.po.FastDfsFile;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能描述: FastDfs文件系统的操作
 * 项目名称:changgou-parent
 * 创建日期:2020/4/9
 *
 * @author Lenovo
 */
@Slf4j
@Data
public class FastDfsClient {

    static {
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
            ClientGlobal.init(filePath);
        } catch (Exception e) {
            log.error("FastDFS Client Init Fail!", e);
        }
    }

    /***
     * 文件上传
     *
     * @param file 上传的文件
     * @return String[] 返回组名和文件的存储路径
     */
    public static String[] upload(FastDfsFile file) {
        //获取文件的作者
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", file.getAuthor());

        //接收返回数据
        String[] uploadResults = null;
        StorageClient storageClient = null;
        try {
            //创建StorageClient客户端对象
            storageClient = getTrackerClient();

            /***
             * 文件上传
             * 1)文件字节数组
             * 2)文件扩展名
             * 3)文件作者
             */
            uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), meta_list);
        } catch (Exception e) {
            log.error("Exception when uploadind the file:" + file.getName(), e);
        }

        if (uploadResults == null && storageClient != null) {
            log.error("upload file fail, error code:" + storageClient.getErrorCode());
        }
        return uploadResults;
    }

    /***
     * 获取文件信息
     *
     * @param groupName:组名
     * @param remoteFileName：文件存储完整名
     * @return FileInfo
     */
    public static FileInfo getFile(String groupName, String remoteFileName) {
        try {
            StorageClient storageClient = getTrackerClient();
            return storageClient.get_file_info(groupName, remoteFileName);
        } catch (Exception e) {
            log.error("Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }

    /***
     * 文件下载
     *
     * @param groupName
     * @param remoteFileName
     * @return InputStream
     */
    public static InputStream downFile(String groupName, String remoteFileName) {
        try {
            //创建StorageClient
            StorageClient storageClient = getTrackerClient();

            //下载文件
            byte[] fileByte = storageClient.download_file(groupName, remoteFileName);
            InputStream ins = new ByteArrayInputStream(fileByte);
            return ins;
        } catch (Exception e) {
            log.error("Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }

    /***
     * 文件删除
     * @param groupName
     * @param remoteFileName
     * @throws Exception
     */
    public static void deleteFile(String groupName, String remoteFileName)
            throws Exception {
        //创建StorageClient
        StorageClient storageClient = getTrackerClient();

        //删除文件
        int i = storageClient.delete_file(groupName, remoteFileName);
    }

    /***
     * 获取Storage组
     * @param groupName
     * @return StorageServer[]
     * @throws IOException
     */
    public static StorageServer[] getStoreStorages(String groupName)
            throws IOException {
        //创建TrackerClient
        TrackerClient trackerClient = new TrackerClient();
        //获取TrackerServer
        TrackerServer trackerServer = trackerClient.getConnection();
        //获取Storage组
        return trackerClient.getStoreStorages(trackerServer, groupName);
    }

    /***
     * 获取Storage信息,IP和端口
     * @param groupName
     * @param remoteFileName
     * @return ServerInfo[]
     * @throws IOException
     */
    public static ServerInfo[] getFetchStorages(String groupName,
                                                String remoteFileName) throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getFetchStorages(trackerServer, groupName, remoteFileName);
    }

    /***
     * 获取Tracker服务地址
     * @return Tracker服务地址
     * @throws IOException
     */
    public static String getTrackerUrl() throws IOException {
        return "http://" + getTrackerServer().getInetSocketAddress().getHostString() + ":" + ClientGlobal.getG_tracker_http_port() + "/";
    }

    /***
     * 获取Storage客户端
     * @return
     * @throws IOException
     */
    private static StorageClient getTrackerClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        return storageClient;
    }

    /***
     * 获取Tracker
     * @return
     * @throws IOException
     */
    private static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerServer;
    }
}
