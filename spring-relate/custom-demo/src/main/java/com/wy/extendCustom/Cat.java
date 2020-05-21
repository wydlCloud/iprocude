package com.wy.extendCustom;

import lombok.Data;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname Cat
 * @Description TODO
 * @Date 2020/5/21 2:18 下午
 */
public class Cat extends Animal{

    public static void main(String[] args) {
        Cat cat=new Cat();
        cat.eat();
        cat.run();
    }

}
