package com.wy.custom;


/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname CustomTest
 * @Description 【通过这种普通的方式来进行，会出现很多容易代码，cat  pig  dog  都有相同的属性，而且都执行了相同的方法，这些方法呢，而且执行的相同的业务
 * 这种情况下，就使得维护和扩展成本很高，如果业务有变动，就会导致在各个实体类中都要进行修改，如果有漏掉的，则必然引发问题，而且工作量巨大，不利于
 * 维护和扩展，这中情况下可以通过继承的方式来解决，把相同的属性和方法提取到父类中去做一些事情】
 * @Date 2020/5/21 2:27 下午
 */

public class CustomTest {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.run();

        Cat cat = new Cat();
        cat.eat();
        cat.run();

        Pig pig = new Pig();
        pig.eat();
        pig.run();
    }
}
