package com.wy.other.polymorphism;

/**
 * @author wy
 * @company
 * @Classname Dog
 * @Description 狗
 */

public class Dog extends Animal {


    @Override
    public void cry() {
        System.out.println("旺旺");
    }

    @Override
    public void eat() {
        System.out.println("想吃骨头🦴");
    }
}
