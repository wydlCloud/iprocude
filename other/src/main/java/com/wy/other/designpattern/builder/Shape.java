package com.wy.other.designpattern.builder;

/**
 * Created on 2019/7/27.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2018
 * Company:
 *
 * @author wy
 */

public class Shape {


    public void draw() {
        System.out.println("绘制图形");
    }

    public void erase() {
        System.out.println("制造图形");
    }

    public void move() {
        System.out.println("删除图形");
    }

    public void getColor() {
        System.out.println("获取颜色");
    }

    public void setColor() {
        System.out.println("设置颜色");
    }


}
