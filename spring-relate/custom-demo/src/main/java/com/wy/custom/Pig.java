package com.wy.custom;

import lombok.Data;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname Pig
 * @Description 动物类（Pig）
 */
@Data
public class Pig {

    private Integer weight;

    private Integer height;

    public  void  eat(){
        System.out.println("-----eat-----");
    }

    public void run(){
        System.out.println("-----run-----");
    }

    public static void main(String[] args) {

        Pig pig=new Pig();
        pig.eat();
        pig.run();

    }

}
