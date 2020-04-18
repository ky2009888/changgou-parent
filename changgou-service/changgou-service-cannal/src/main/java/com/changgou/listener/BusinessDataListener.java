package com.changgou.listener;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.*;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/18
 *
 * @author Lenovo
 */
@CanalEventListener
@Slf4j
public class BusinessDataListener {
    /**
     * 更新数据监听
     *
     * @param eventType 时间类型
     * @param rowData   行数据
     * @UpdateListenPoint(schema = "changgou_business", table = {"tb_ad"})
     */
    @UpdateListenPoint(schema = "changgou_business", table = {"tb_ad"})
    public void adUpdate(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        handleUpdateData(rowData);
    }

    /**
     * 新增数据监听
     *
     * @param eventType 时间类型
     * @param rowData   行数据
     */
    @InsertListenPoint(schema = "changgou_business", table = {"tb_ad"})
    public void adInsert(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        log.info("广告数据发生变化:");
        log.info("-------------------------------------------------------------------------------添加数据之后的数据:");
        handleInsertData(rowData);
    }

    /**
     * 删除数据监听
     *
     * @param eventType 时间类型
     * @param rowData   行数据
     */
    @DeleteListenPoint(schema = "changgou_business", table = {"tb_ad"})
    public void adDelete(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        handleDeleteData(rowData);
    }

    /**
     * 通用处理删除和修改数据
     *
     * @param rowData 数据行
     */
    private void handleDeleteData(CanalEntry.RowData rowData) {
        log.info("广告数据发生变化:");
        log.info("-------------------------------------------------------------------------------更改之前的数据:");
        rowData.getBeforeColumnsList().forEach((c) -> log.info("更改前数据: " + c.getName() + " :: " + c.getValue()));
        log.info("-------------------------------------------------------------------------------更改之后的数据:");
        rowData.getAfterColumnsList().forEach((c) -> log.info("更改后数据: " + c.getName() + " :: " + c.getValue()));
    }

    /**
     * 通用处理删除和修改数据
     *
     * @param rowData 数据行
     */
    private void handleUpdateData(CanalEntry.RowData rowData) {
        log.info("广告数据发生变化:");
        log.info("-------------------------------------------------------------------------------更改之前的数据:");
        rowData.getBeforeColumnsList().forEach((c) -> log.info("更改前数据: " + c.getName() + " :: " + c.getValue()));
        log.info("-------------------------------------------------------------------------------更改之后的数据:");
        rowData.getAfterColumnsList().forEach((c) -> log.info("更改后数据: " + c.getName() + " :: " + c.getValue()));
    }

    /**
     * 通用处理新增数据
     *
     * @param rowData 数据行
     */
    private void handleInsertData(CanalEntry.RowData rowData) {
        log.info("-------------------------------------------------------------------------------更改之后的数据:");
        rowData.getAfterColumnsList().forEach((c) -> log.info("更改后数据: " + c.getName() + " :: " + c.getValue()));
    }

    /**
     * 通用的操作,进行数据的增加，修改，删除操作的通用操作
     *
     * @param eventType 事件类型
     * @param rowData   行数据
     */
    @ListenPoint(schema = "changgou_business", table = {"tb_ad"},
            eventType = {CanalEntry.EventType.DELETE, CanalEntry.EventType.UPDATE, CanalEntry.EventType.INSERT}, destination = "example")
    public void businessData(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        switch (eventType.getNumber()) {
            //INSERT
            case 1:
                handleInsertData(rowData);
                break;
            //UPDATE
            case 2:
                handleUpdateData(rowData);
                break;
            //DELETE
            case 3:
                handleDeleteData(rowData);
                break;
            default:
                break;
        }
    }
}
