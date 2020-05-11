#自定义框架设计
 使用端
--- 
- 1.提供核心配置文件
- 2.sqlMapConfig.xml存放数据源信息，引入mapper.xml文件
- 3.Mapper.xml语句文件信息

---
 框架端
---
- 1.读取配置文件（读取完以后以流的形式存在，我们不能将读取到的配置信息以流的形式存放在内存中，不方便操作，但是可以通过面向对象的思想，可以创建javabean来进行存储）
创建Resource类  方法getResourceAsStream(String path)
-  1）Configuration:核心配置类：存储数据库的基本信息、Map<唯一标识，Mapper> 唯一标识:namespace+"."+id  存放sqlMapConfig.xml 解析出来的内容
-  2）MapperStatement:映射配置类  sql语句、statement类型、输入参数类型、输出参数类型  存放mapper.xml解析出来的内容


- 2.解析配置文件dom4j （创建SqlSessionFactoryBuilder类 创建SqlSessionFactory  build(InputStream in)方法）：
- 1）使用dom4j解析配置文件，将解析出来的内容，封装到Configuration和MappedStatement中
- 2）创建SqlSessionFactory对象，生产sqlSession: 会话对象

- 3.创建SqlSessionFactory（方法：openSession（）,获取sqlSession接口的实现类实例对象）  默认DefaultSessionFactory   生产sqlSession

- 4.创建sqlSession接口及实现类：主要封装crud方法
    - 方法 
    
          
           selectList(String StatementId,Object param)  查询所有
           selectOne(String StatementId,Object param)   查询单个
           close   释放资源
           具体实现：封装jdbc完成对数据库表的查询操作
- 5 创建Executor 接口及实现类SimpleExcutor实现类  query(Conguration,MappedStatement,Object... params)  :执行其实就是JDBC代码         
---
涉及到的设计模式：构建者模式，工厂模式、代理模式   

