package com.wy.other.polymorphism;

/**
 * @author wy
 * @company
 * @Classname Animal
 * @Description 动物类
 */

public class Animal {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void cry(){
        System.out.println("我不知道叫什么");
    }
    public void eat(){
        System.out.println("我不知道想吃什么");
    }

    public void setName(String name) {
        this.name = name;
    }
}
