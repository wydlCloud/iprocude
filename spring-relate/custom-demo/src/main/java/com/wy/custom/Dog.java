package com.wy.custom;

import lombok.Data;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname custom
 * @Description 动物类（Dog）
 * @Date 2020/5/21 2:12 下午
 */
@Data
public class Dog {
    /**
     * 高度
     */
    private Integer weight;
    /**
     * 宽度
     */
    private Integer height;

    public void eat(){
        System.out.println(" --------eat--------");
    }
    public void run(){
        System.out.println("--------run--------");
    }

    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.eat();
        dog.run();
    }

}
