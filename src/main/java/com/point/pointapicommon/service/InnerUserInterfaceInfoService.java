package com.point.pointapicommon.service;

/**
 * 内部用户接口信息服务
 */
public interface InnerUserInterfaceInfoService {

    /**
     * 判断是否还用剩余的调用次数
     *
     * @param interfaceInfoId
     * @param userId
     * @return boolean
     * @Author point
     * @Date 16:51 2023/7/29
     **/
    boolean hasLeftNum(long interfaceInfoId, long userId);

    /**
     * 调用接口统计
     *
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    /**
     * 往redis中插入nonce，格式为userId-interfaceInfoId-nonce
     *
     * @param nonce
     * @param interfaceInfoId
     * @param userId
     * @return boolean
     * @Author point
     * @Date 21:18 2023/8/22
     **/
    boolean insertNonce(long nonce, long interfaceInfoId, long userId);
}
