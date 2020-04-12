package com.wy.other.Initialize;

/**
 * Created on 2018/7/29.
 * Title: Simple
 * Description:Tag对象的定义故意到处散布，以证明它们都会在构建器进入或者其他任何事情之前得到初始化。tag1在构建器内重新进行初始化
 * Copyright: Copyright(c) 2018
 * Company:
 *
 * @author wy
 */
public class Card {
    static String k;
    Tag tag = new Tag(1);

    Card() {
        System.out.println();
        tag1 = new Tag(33);
    }


    Tag tag2 = new Tag(2);

    void f() {
        System.out.println("f()");
    }

    Tag tag1 = new Tag("ssssss");
}
