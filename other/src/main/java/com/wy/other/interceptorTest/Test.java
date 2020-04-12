package com.wy.other.interceptorTest;


import lombok.extern.slf4j.Slf4j;

/**
 * Created on 2019/4/20.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2018
 * Company:
 *
 * @author wy
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        RoleService roleService = new RoleServiceImpl();
        Interceptor interceptor = new RoleInterceptor();
        RoleService roleService1 = (RoleService) ProxyBeanUtil.getBean(roleService, interceptor);
        Role role = new Role((long) 1, "吕姝雅", "小女子");
        roleService1.printRole(role);
        System.out.println("===================测试出现异常的情况" + "====================");
        role = null;
        roleService1.printRole(role);
        try {
            // System.out.println(role1.getId());
            log.info("执行正常");
        } catch (Exception e) {
            log.error("出现异常");
        }


    }
}
