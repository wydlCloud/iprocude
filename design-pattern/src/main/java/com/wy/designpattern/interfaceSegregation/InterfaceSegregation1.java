package com.wy.designpattern.interfaceSegregation;

/**
 * @Classname InterfaceSegregation1
 * @Description 接口隔离原则
 *
 * 这种设计是不合理的，因为A依赖于接口InterfaceSegregation1  B实现接口InterfaceSegregation1  D实现接口InterfaceSegregation1
 * C依赖于接口InterfaceSegregation1  但是A依赖（使用）接口的 1 2，3方法，C依赖于接口的 1，4，5方法，
 * 所以这种情况下，A依赖于不使用接口 4，5  C依赖于不使用接口的2，3
 * 所以依据接口隔离原则，是不合理的，应该进行接口的细分
 *
 * 比如InterfaceSegregation1 中的1方法抽象一个单独的接口
 * 比如InterfaceSegregation1 中的2，3方法抽象一个单独的接口
 * 比如InterfaceSegregation1 中的4，5方法抽象一个单独的接口
 * 然后B实现1和2
 * 然后D实现4和5
 * 这种情况，A依赖于B的实现，所以这个时候，就不冗余其他不适用的接口  4，5
 * 这种情况，C依赖于D的实现，所以这个时候，就不冗余其他使用的接口  2，3
 * 进行接口隔离，符合接口隔离原则
 *
 * @Date 2021/1/22 11:35 上午
 * @Company 杭州光云科技有限公司
 * @Author yunze
 */
public interface InterfaceSegregation1 {
    void interface1();

    void interface2();

    void interface3();

    void interface4();

    void interface5();
}

class B implements InterfaceSegregation1{
    @Override
    public void interface1() {
        System.out.println("B interface1");
    }

    @Override
    public void interface2() {
        System.out.println("B interface2");
    }

    @Override
    public void interface3() {
        System.out.println("B interface3");
    }

    @Override
    public void interface4() {
        System.out.println("B interface4");

    }

    @Override
    public void interface5() {
        System.out.println("B interface5");
    }
}

class D implements InterfaceSegregation1{
    @Override
    public void interface1() {
        System.out.println("D interface1");
    }

    @Override
    public void interface2() {
        System.out.println("D interface2");
    }

    @Override
    public void interface3() {
        System.out.println("D interface3");
    }

    @Override
    public void interface4() {
        System.out.println("D interface4");

    }

    @Override
    public void interface5() {
        System.out.println("D interface5");
    }
}


class A {
   void interface1(InterfaceSegregation1 interfaceSegregation1){
       interfaceSegregation1.interface1();
       interfaceSegregation1.interface2();
       interfaceSegregation1.interface3();
   }
    public static void main(String[] args) {
        A a=new A();
        a.interface1(new B());
    }

}

class C{
    void interface1(InterfaceSegregation1 interfaceSegregation1){
        interfaceSegregation1.interface1();
        interfaceSegregation1.interface4();
        interfaceSegregation1.interface5();
    }
    public static void main(String[] args) {
        C c=new C();
        c.interface1(new D());
    }
}
