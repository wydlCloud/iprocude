package com.wy.concurrent.reflect;

/**
 * Created on 2019/4/15.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class ReflectImplServiceImpl2 {
    private String name;

    public ReflectImplServiceImpl2(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("hello" + name);
    }


}
