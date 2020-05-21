package com.wy.other.polymorphism;

/**
 * @author wy
 * @company
 * @Classname Food
 * @Description 食物
 */

public class Food {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void showName(){
        System.out.println("不知道是什么食物");
    }
}
