package com.wy.extendCustom;

import lombok.Data;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname custom
 * @Description 动物类（Dog）
 */

public class Dog extends Animal{

    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.eat();
        dog.run();
    }

}
