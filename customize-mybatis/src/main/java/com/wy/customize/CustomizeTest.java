package com.wy.customize;

import com.alibaba.fastjson.JSON;
import com.wy.customize.mapper.UserMapper;
import com.wy.customize.pojo.User;
import com.wy.customizeframe.io.Resources;
import com.wy.customizeframe.sqlSession.DefaultSqlSession;
import com.wy.customizeframe.sqlSession.SqlSession;
import com.wy.customizeframe.sqlSessionFactory.SqlSessionFactory;
import com.wy.customizeframe.sqlSessionFactory.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import sun.misc.ProxyGenerator;

import java.beans.PropertyVetoException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname CustomizeTest
 * @Description 自定义框架测试类（支持传入自定义实体类作为入参，关于入参为int long等信息的还没有进行相关功能的编写和校验）
 * @Date 2020/5/15 4:21 下午
 */

public class CustomizeTest {

    public static void main(String[] args) throws Exception {
        /* step 传统方式执行jdbc方式*/
//        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        SqlSession sqlSession = build.openSession();
//        User user=new User();
//        user.setId(1);
//        user.setUsername("张三");
//      User user1=sqlSession.selectOne("User.selectOne",user);

//        List<User> objectList = sqlSession.selectList("User.selectList");
//        System.out.println(JSON.toJSONString(user1));

        /* step 通过基本mapper方式执行查询操作*/
//        UserMapper userMapper = new UserMapperImpl();
//        List<User> users = userMapper.selectList();
//        System.out.println(users);
//
//        System.out.println("------------------------------------------------------------");
//        User user=new User();
//        user.setId(1);
//        user.setUsername("张三");
//        User user1 = userMapper.selectOne(user);
//        System.out.println(user1);


        /* step3 通过代理类的方式来进行 */
        InputStream resourceAsSteam = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findAll();
        System.out.println(all);

    }


}
