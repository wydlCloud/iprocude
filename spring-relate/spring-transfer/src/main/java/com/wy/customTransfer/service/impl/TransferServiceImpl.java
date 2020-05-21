package com.wy.customTransfer.service.impl;

import com.wy.customTransfer.mapper.AccountMapper;
import com.wy.customTransfer.mapper.impl.JDBCAccountMapperImpl;
import com.wy.customTransfer.pojo.Account;
import com.wy.customTransfer.service.TransferService;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname TransferServiceImpl
 * @Description 转账具体实现类
 * @Date 2020/5/21 7:18 下午
 */

public class TransferServiceImpl implements TransferService {
    // 最传统的方式来实现
    private AccountMapper accountMapper=new JDBCAccountMapperImpl();
    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {
        Account from = accountMapper.queryAccountByCardNo(fromCardNo);
        int money1 = from.getMoney();
        Account to = accountMapper.queryAccountByCardNo(toCardNo);
        int money2 = to.getMoney();
        from.setMoney(money1-money);
        to.setMoney(money2+money);
        accountMapper.updateAccountByCardNo(from);
        accountMapper.updateAccountByCardNo(to);



    }
}
