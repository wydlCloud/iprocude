package com.wy.other.polymorphism;

/**
 * @author wy
 * @company
 * @Classname Cat
 * @Description 猫
 * @Date 2020/4/21 3:45 下午
 */

public class Cat extends Animal {
    @Override
    public void cry() {
        System.out.println("喵喵");
    }

    @Override
    public void eat() {
        System.out.println("想吃鱼🐟");
    }
}
