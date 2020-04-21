package com.wy.other.polymorphism;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname DuoTaiDemo
 * @Description 所谓多态，就是指一个引用(类型)在不同的情况下的多种状态，也可以理解为多态是指通过父类的指针来调用在不同子类中的实现的方法而已
 * @Date 2020/4/21 3:49 下午
 */

public class DuoTaiDemo {
    public static void main(String[] args) {
        Master master=new Master();
        Animal animal = new Dog();
        Food food = new Bone();
        master.feed(animal,food);
    }
}
