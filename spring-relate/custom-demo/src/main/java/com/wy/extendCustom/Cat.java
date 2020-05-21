package com.wy.extendCustom;

import lombok.Data;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname Cat
 * @Description TODO
 */
public class Cat extends Animal{

    public static void main(String[] args) {
        Cat cat=new Cat();
        cat.eat();
        cat.run();
    }

}
