package com.wy.factoryTransfer.mapper;

import com.wy.factoryTransfer.pojo.Account;

import java.sql.SQLException;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname AccountMapper
 * @Description mapper  实体类
 * @Date 2020/5/21 5:36 下午
 */

public interface AccountMapper {
    /**
     * 根据卡号查询账号信息
     */
    public Account queryAccountByCardNo(String cardNo) throws SQLException;

    /**
     * 根据卡号更新账号信息
     * @param account
     * @return
     */
    public int updateAccountByCardNo(Account account) throws SQLException;
}
