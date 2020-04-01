package com.wy.concurrent.listener.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname MailSend2
 * @Description TODO
 * @Date 2020/4/1 11:17 下午
 */

public class MailSend2 implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void sendMail2(String to) {
        System.out.println("MailSender:模拟发送邮件2...");
        MailSendEvent event = new MailSendEvent(this.applicationContext, to);
        applicationContext.publishEvent(event);
    }
}
