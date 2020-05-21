package com.wy.customTransfer.service;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname TransferService
 * @Description TODO
 * @Date 2020/5/21 7:18 下午
 */
public interface TransferService {
    void transfer(String fromCardNo,String toCardNo,int money) throws Exception;

}
