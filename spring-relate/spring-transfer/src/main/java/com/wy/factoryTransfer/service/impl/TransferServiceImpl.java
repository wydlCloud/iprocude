package com.wy.factoryTransfer.service.impl;

import com.wy.factoryTransfer.mapper.AccountMapper;
import com.wy.factoryTransfer.mapper.impl.JDBCAccountMapperImpl;
import com.wy.factoryTransfer.pojo.Account;
import com.wy.factoryTransfer.service.TransferService;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname TransferServiceImpl
 * @Description 转账具体实现类
 */

public class TransferServiceImpl implements TransferService {
    // s1 最传统的方式来实现
    // private AccountMapper accountMapper=new JDBCAccountMapperImpl();

    // s2 简易版ioc的方式来实现对象的注入，实现解耦的目的，但是我们还不想要后面的这一段，加上感觉不是太符合面向接口开发的最优原则
    // =new XmlConfigApplicationContext().getBean("accountMapper");
    // 这样的话，就可以通过对父标签进行依赖注入的方式来实现，在XmlConfigApplicationContext中进行了依赖注入的解析
    // private AccountMapper accountMapper=new XmlConfigApplicationContext().getBean("accountMapper");

    /* step3 依赖注入的方式来实现，但是需要set方法的存在 */
    private AccountMapper accountMapper;

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {
        Account from = accountMapper.queryAccountByCardNo(fromCardNo);
        int money1 = from.getMoney();
        Account to = accountMapper.queryAccountByCardNo(toCardNo);
        int money2 = to.getMoney();
        from.setMoney(money1 - money);
        to.setMoney(money2 + money);
        accountMapper.updateAccountByCardNo(from);
        accountMapper.updateAccountByCardNo(to);


    }
}
