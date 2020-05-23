package com.wy.factoryTransfer.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname XmlConfigApplicationContext
 * @Description 读取配置文件创建对象上下文
 *
 * 在这里算是模拟简易版的ioc的实现，
 * 开发者值需要进行简单的配置即可，其他的交给ioc 来完成，
 * 起到了解耦的作用，一个类依赖另一个类，不需要进行在此类中进行new对象，直接从容器中取即可
 * 方便配置，如果定义了一个接口，实现类实现了一个接口，如果有一天，你需要更改那个接口的实现类，那个实现类已经不能够再继续使用，
 * 需要更换，如果沿用之前的方式的话，这样所有引用的地方都需要进行修改，维护成本较高，开发成本较高，而且没有解耦，所以耦合性很强
 * 那么维护成本和扩展性就比较低，牵一发可能动全身
 * 所以通过这种方式就可以解决这个问题，只需要修改配置即可，一改即用
 */
public class BeanFactory {
    /**
     * 任务一：读取解析xml，通过反射技术实例化对象并且存储待用（map集合）
     * 任务二：对外提供获取实例对象的接口（根据id获取）
     */

    private static ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();  // 存储对象

    static {
        /* step1 通过类加载器，进行加载和转化为字节码输入流 */
        InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
        /* step2 通过dom4j进行解析此xml文件转换为的字节输入流 */
        // 解析xml
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(resourceAsStream);
            /* step3 获取根节点*/
            Element rootElement = document.getRootElement();
            /* step4 获取节点下的所有的关于bean标签的元素集合*/
            List<Element> elementList = rootElement.selectNodes("//bean");
            /* step5 遍历此元素集合,bean标签表示的都是要创建的对象，
            这种情况下，知道全限定类名的情况下，要通过反射来实现，创建对象通过反射的的方式来进行实现 */
            elementList.forEach(x -> {
                // 获取到id表示的名称
                String id = x.attributeValue("id");
                // 获取类的全限定名称
                String clazz = x.attributeValue("class");
                try {
                    // 有类的全限定名，通过反射来生成对象，id作为key，生成的对象作为value，存储在map中
                    Class<?> aClass = Class.forName(clazz);
                    // 通过反射实例化对象
                    Object bean = aClass.newInstance();
                    // 存储到map中
                    beanMap.put(id, bean);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
            /* step6 这一步要进行检测依赖注入的情况了，因为bean标签中可能会有通过ref进行依赖注入的情况，bean标签的对象已经创建完成
             * 在这一步，要把其他的对象注入进去，说通俗易懂一点就是，对象中已经创建了，但是里面的有些需要用到的值并没有赋值操作呢，
             * 所以，这也是需要做的，不然的话，我既然有你这个实例，正常情况下来讲，我就是有用的，所以要进行赋值
             *  */
            // 实例化完成之后维护对象的依赖关系，检查哪些对象需要传值进入，根据它的配置，我们传入相应的值
            // 有property子元素的bean就有传值需求
            List<Element> propertyList = rootElement.selectNodes("//property");
            propertyList.forEach(x -> {
                // 获取名称
                String name = x.attributeValue("name");
                // 获取需要注入的实例信息，此标签可以理解为bean标签的id ，可以通过此ref映射bean的id，通过ref标签标示的值ioc中进行寻找
                String ref = x.attributeValue("ref");
                String setName = "set" + "." + name;
                // 找到当前需要被处理依赖关系的bean  通俗易懂解释，就是通过此标签来寻找父标签
                Element parentElement = x.getParent();
                // 通过id获取到此id 的值，到beanMap中取出当前的bean对象
                String parentId = parentElement.attributeValue("id");
                // 获取bean对象
                Object target = beanMap.get(parentId);
                Method[] methods = target.getClass().getMethods();
                for (int i = 0; i < methods.length; i++) {
                    Method method = methods[i];
                    if (setName.equalsIgnoreCase(method.getName())) {
                        try {
                            // 该方法就是 setAccountDao(AccountDao accountDao)
                            method.invoke(target, beanMap.get(ref));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
                // 把重新赋值之后的对象重新放进缓存中
                beanMap.put(parentId, target);
            });
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static <T> T getBean(String id) {
        return (T) beanMap.get(id);
    }

}
