package com.wy.other.polymorphism;

/**
 * @author wy
 * @company
 * @Classname Cat
 * @Description 猫
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
