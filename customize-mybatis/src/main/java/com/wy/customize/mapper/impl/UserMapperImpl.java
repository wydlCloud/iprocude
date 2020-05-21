//package com.wy.customize.mapper.impl;
//
//import com.wy.customize.mapper.UserMapper;
//import com.wy.customize.pojo.User;
//import com.wy.customizeframe.io.Resources;
//import com.wy.customizeframe.sqlSession.SqlSession;
//import com.wy.customizeframe.sqlSessionFactory.SqlSessionFactory;
//import com.wy.customizeframe.sqlSessionFactory.SqlSessionFactoryBuilder;
//
//import java.io.InputStream;
//import java.util.List;
//
///**
// * @author wy
// * @company wy(中国)网络科技
// * @Classname UserMapperImpl
// * @Description 此种是伪mapper方式，因为通过这种方式的话，会存在一些问题， 如果不适用此方式，在应用层去操作dao层，显然也不合理
// * （1） 存在重复编码问题
// * eg：  InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
// *         SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
// *         SqlSession sqlSession = build.openSession();
// *         这三行代码，每个实现的方法都要进行编写，当然可以通过抽象出去作为公共方法，但是也是每个方法也是存在调用重复方法问题
// * （2） 因为在调用方法的时候，命名命名空间是写死的，
// * 如果在xml中，修改了命名空间的话，还是存在不方便进行维护的问题，这也存在硬编码问题，而且不易于进行维护，可扩展性也是有限的
// * List<User> queryUserList = sqlSession.selectList("User.selectList");
// *
// * 此种可以理解为伪mapper模式，如果想解决这个问题，不使用这个实体类就解决了这问题，但是不使用这种方式，要选择其他的方式来解决这个问题，当然有方式
// * 可以选择代理模式，通过代理类来表示当前的实现类，同样实现当前的效果，所以下面通过代理类来解决这个问题
// */
//
//public class UserMapperImpl implements UserMapper {
//    @Override
//    public List<User> selectList() throws Exception {
//        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        SqlSession sqlSession = build.openSession();
//        List<User> queryUserList = sqlSession.selectList("User.selectList");
//        return queryUserList;
//    }
//
//    @Override
//    public User selectOne(User user) throws Exception {
//        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        SqlSession sqlSession = build.openSession();
//        User queryUser = sqlSession.selectOne("User.selectOne", user);
//        return queryUser;
//    }
//}
