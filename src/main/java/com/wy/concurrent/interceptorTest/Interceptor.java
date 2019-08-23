package com.wy.concurrent.interceptorTest;

/**
 * Created on 2019/4/20.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2018
 * Company:
 * @author wy
 */
public interface Interceptor {
    public void before(Object object);
    public void after(Object o);
    public  void afterReturning(Object o);
    public void afterThrowing(Object o);
}