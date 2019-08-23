package com.wy.concurrent.proxy;

/**
 * Created on 2019/5/31.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello world 你好"+name);
    }
}
