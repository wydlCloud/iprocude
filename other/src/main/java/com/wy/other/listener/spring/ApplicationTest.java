package com.wy.other.listener.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author wy
 * @company
 * @Classname ApplicationTest
 * @Description TODO
 * @Date 2020/4/1 10:42 下午
 */

public class ApplicationTest {
    public static void main(String[] args) {
        String resourceFile = "/spring/spring-context.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);
        // 通过此方法可以获取ioc容器中的bean
        MailSend mailSend = BeanUtils.getBean("mailSender");
        mailSend.sendMail("test mails");
        MailSend2 bean2 = ctx.getBean(MailSend2.class);
        MailSend bean1 = ctx.getBean(MailSend.class);
        // 在重启初始化完之后呢，就会回调setApplicationEvent方法
        // 此方法呢，主要是改变事件源 向监听器发送事件对象
//        bean2.sendMail2("test mail2.");
      //  bean1.sendMail("test mail.");
        System.out.println("done.");
    }
}
