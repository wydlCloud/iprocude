package com.wy.other.polymorphism;

/**
 * @author wy
 * @company 中国网络科技
 * @Classname Bone
 * @Description 食物类
 */

public class Bone extends Food {
    @Override
    public void showName() {
        System.out.println("食物：骨头🦴");
    }
}
