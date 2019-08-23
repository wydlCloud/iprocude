package com.wy.concurrent.designpattern.builder;

/**
 * Created on 2019/7/27.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2018
 * Company:
 *
 * @author wy
 */
public class Test {
    static void doStuff(Shape shape) {
        shape.draw();


//        shape.erase();
//        shape.getColor();
//        shape.setColor();
//        shape.move();
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
       /* Triangle triangle = new Triangle();
        Line line = new Line();*/
        doStuff(circle);
      /*  doStuff(triangle);
        doStuff(line);*/
    }
}
