package com.wy.custom;

import lombok.Data;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname Cat
 * @Description TODO
 * @Date 2020/5/21 2:18 下午
 */
@Data
public class Cat {

    private Integer weight;
    private Integer height;

    public void eat(){
        System.out.println("-----eat-----");
    }

    public void run(){
        System.out.println("----run-----");
    }

    public static void main(String[] args) {
        Cat cat=new Cat();
        cat.eat();
        cat.run();
    }

}