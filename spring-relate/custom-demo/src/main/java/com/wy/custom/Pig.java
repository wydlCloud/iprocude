package com.wy.custom;

import lombok.Data;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname Pig
 * @Description 动物类（Pig）
 * @Date 2020/5/21 2:15 下午
 */
@Data
public class Pig {

    private Integer weight;

    private Integer height;

    public  void  eat(){
        System.out.println("-----eat-----");
    }

    public void run(){
        System.out.println("-----run-----");
    }

    public static void main(String[] args) {

        Pig pig=new Pig();
        pig.eat();
        pig.run();

    }

}
