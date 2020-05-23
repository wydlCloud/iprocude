package com.wy.other.designpattern.factory.factorymethod;


import com.wy.other.designpattern.factory.simpleFactory.inoodle.INoodles;

public class Test {
    public static void main(String[] args) {
        INoodlesFactory noodlesFactory = new LzINoodlesFactory();
        INoodles noodles = noodlesFactory.createNoodles();
        noodles.desc();
    }
}
