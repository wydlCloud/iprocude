package com.wy.other.polymorphism;

/**
 * @author wy
 * @company
 * @Classname Master
 * @Description 主人
 * @Date 2020/4/21 3:48 下午
 */

public class Master {
    public void feed(Animal animal,Food food){
        animal.cry();
        animal.eat();
        food.showName();
    }
}
