package com.wy.extendCustom;

import lombok.Data;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname Pig
 * @Description 动物类（Pig）
 * @Date 2020/5/21 2:15 下午
 */
public class Pig extends Animal{


    public static void main(String[] args) {

        Pig pig=new Pig();
        pig.eat();
        pig.run();

    }

}
