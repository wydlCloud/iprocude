package com.wy.other.polymorphism;

/**
 * @author wy
 * @company
 * @Classname Fish
 * @Description 鱼
 * @Date 2020/4/21 3:47 下午
 */

public class Fish extends Food {
    @Override
    public void showName() {
        System.out.println("食物：鱼");
    }

}
