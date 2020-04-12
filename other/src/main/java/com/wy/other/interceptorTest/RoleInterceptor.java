package com.wy.other.interceptorTest;


/**
 * Created on 2019/4/20.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2018
 * Company:
 *
 * @author wy
 */
public class RoleInterceptor implements Interceptor {
    @Override
    public void before(Object object) {
        System.out.println("打印之前");
    }

    @Override
    public void after(Object o) {
        System.out.println("成功打印");

    }

    @Override
    public void afterReturning(Object o) {
        System.out.println("打印完成");
    }

    @Override
    public void afterThrowing(Object o) {
        System.out.println("打印过程中执行异常操作，出现异常");

    }
}
