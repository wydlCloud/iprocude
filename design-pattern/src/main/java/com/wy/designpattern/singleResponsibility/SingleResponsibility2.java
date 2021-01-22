package com.wy.designpattern.singleResponsibility;

/**
 * @Classname SingleResponsibility1
 * @Description 单一职责模式  1
 *
 *
 * 进行职责细分，符合单一职责，每个类来负责自己这一项的职责，海陆空各一个，各自负责自己的一个域，这样对于可读性和后续的维护性可靠性都会有所增强
 *
 * 也大大提高了可扩展性，比如空中类添加了某些特性和特有的功能，不会直接影响其他的逻辑，而且，只需要修改这一个类中的方法即可，
 * 这样对于扩展性和维护性也大大提高，也高内聚和低耦合，使得维护性会提高。
 * @Date 2021/1/22 10:35 上午
 * @Company 杭州光云科技有限公司
 * @Author yunze
 */
public class SingleResponsibility2 {
    public static void main(String[] args) {
        String roadName = "汽车";
        String airName = "飞机";
        String waterName = "轮船";
        RoadVehicle roadVehicle=new RoadVehicle();
        roadVehicle.run(roadName);
        AirVehicle airVehicle=new AirVehicle();
        airVehicle.run(airName);
        WaterVehicle waterVehicle=new WaterVehicle();
        waterVehicle.run(waterName);
    }
}

class RoadVehicle {
    void run(String name) {
        System.out.println(name + "-------在路上跑");
    }

}

class AirVehicle {
    void run(String name) {
        System.out.println(name + "-------在空中飞");
    }

}

class WaterVehicle {
    void run(String name) {
        System.out.println(name + "-------在海中游");
    }

}
