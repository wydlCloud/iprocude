package com.wy.designpattern.singleResponsibility;

/**
 * @Classname SingleResponsibility1
 * @Description 单一职责模式  1
 *
 * 关于此种设计是不符合单一职责原则
 *
 * 因为通过交通工具类来泛指出行，因为交通工具会分为海陆空三种交通工具，通过此一个类来处理三种在后期处理过程中可能就会出现问题，
 * 而且会让代码的可读性和可维护性大大降低，要尽可能的符合单一职责，这也是程序设计的规范
 * @Date 2021/1/22 10:35 上午
 * @Company 杭州光云科技有限公司
 * @Author yunze
 */
public class SingleResponsibility1 {
    public static void main(String[] args) {
        String roadName = "汽车";
        String airName = "飞机";
        String waterName = "轮船";
        Vehicle vehicle=new Vehicle();
        vehicle.run(roadName);
        vehicle.run(airName);
        vehicle.run(waterName);
    }
}

class Vehicle {
    void run(String name) {
        System.out.println(name + "-------在路上跑");
    }

}
