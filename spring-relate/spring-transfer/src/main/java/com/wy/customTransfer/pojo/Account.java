package com.wy.customTransfer.pojo;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname Account
 * @Description 账户实体信息类
 */

public class Account {
    private String cardNo;
    private String name;
    private int money;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
