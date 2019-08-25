package com.wy.concurrent.interceptorTest;


/**
 * Created on 2019/4/20.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2018
 * Company:
 *
 * @author wy
 */
public class RoleServiceImpl implements RoleService {

    @Override
    public void printRole(Role role) {
        System.out.println("id=" + role.getId() + "=====" + "note" + role.getNote() + "=====" + "RoleName" + role.getRoleName());
    }
}
