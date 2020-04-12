package com.wy.other.proxy;

/**
 * Created on 2019/5/31.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class ProxyTest {
    public static void main(String[] args) {
        HelloServiceProxy proxy = new HelloServiceProxy();
        HelloService service = new HelloServiceImpl();
        //绑定代理对象。
        service = (HelloService) proxy.bind(service);
        //这里service经过绑定，就会进入invoke方法里面了。
        service.sayHello("张三");
    }
}
