package com.wy.extendCustom;

import lombok.Data;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname custom
 * @Description 动物类（Dog）
 * @Date 2020/5/21 2:12 下午
 */

public class Dog extends Animal{

    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.eat();
        dog.run();
    }

}
