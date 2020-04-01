package com.wy.concurrent.listener.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname ApplicationTest
 * @Description TODO
 * @Date 2020/4/1 10:42 下午
 */

public class ApplicationTest {
    public static void main(String[] args) {
        String resourceFile = "/spring/spring-context.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);
        MailSend2 bean2 = ctx.getBean(MailSend2.class);
        MailSend bean1 = ctx.getBean(MailSend.class);
        // 在重启初始化完之后呢，就会回调setApplicatonEvent方法i
        // 此方法呢，主要是改变事件源 向监听器发送事件对象
        bean2.sendMail2("test mail2.");
      //  bean1.sendMail("test mail.");
        System.out.println("done.");
    }
}
