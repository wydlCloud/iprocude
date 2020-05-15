package com.wy.customize;

import com.alibaba.fastjson.JSON;
import com.wy.customize.pojo.User;
import com.wy.customizeframe.io.Resources;
import com.wy.customizeframe.sqlSession.SqlSession;
import com.wy.customizeframe.sqlSessionFactory.SqlSessionFactory;
import com.wy.customizeframe.sqlSessionFactory.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname CustomizeTest
 * @Description 自定义框架测试类
 * @Date 2020/5/15 4:21 下午
 */

public class CustomizeTest {

    public static void main(String[] args) throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        User user=new User();
        user.setId(1);
        user.setUsername("张三");
      User user1=sqlSession.selectOne("User.selectOne",user);

//        List<User> objectList = sqlSession.selectList("User.selectList");
        System.out.println(JSON.toJSONString(user1));
    }
}
