package com.wy.designpattern.singleResponsibility;

/**
 * @Classname SingleResponsibility1
 * @Description 单一职责模式  3
 * <p>
 * 这种方式呢，适合比较业务比较简单的，后续一定不会出现太多方法的设计，因为接口的设计，方法尽可能的要少，这样才能间接保证
 * <p>
 * 结构没有那么复杂。可维护，可扩展。如果业务复杂，还是要采用拆分类的方式来实现，具体要根据自己的业务需求来设计，避免过度设计
 * 倡导合理设计
 * @Date 2021/1/22 10:35 上午
 * @Company 杭州光云科技有限公司
 * @Author yunze
 */
public class SingleResponsibility3 {
    public static void main(String[] args) {
        String roadName = "汽车";
        String airName = "飞机";
        String waterName = "轮船";
        Vehicle1 vehicle1 = new Vehicle1();
        vehicle1.roadRun(roadName);
        vehicle1.airRun(airName);
        vehicle1.waterRun(waterName);
    }
}

class Vehicle1 {
    void roadRun(String name) {
        System.out.println(name + "-------------路上跑");
    }

    void airRun(String name) {
        System.out.println(name + "--------------空中飞");
    }

    void waterRun(String name) {
        System.out.println(name + "-------------海中游");
    }
}
