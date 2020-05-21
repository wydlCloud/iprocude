package com.wy.customTransfer.service;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname TransferService
 * @Description TODO
 */
public interface TransferService {
    void transfer(String fromCardNo,String toCardNo,int money) throws Exception;

}
