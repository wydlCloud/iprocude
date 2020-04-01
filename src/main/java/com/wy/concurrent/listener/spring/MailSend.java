package com.wy.concurrent.listener.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname MailSend
 * @Description 事件源
 * @Date 2020/4/1 10:40 下午
 */

public class MailSend implements ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext ctx)
            throws BeansException {
        this.ctx = ctx;

    }

    public void sendMail(String to) {
        System.out.println("MailSender:模拟发送邮件...");
        MailSendEvent event = new MailSendEvent(this.ctx, to);
        ctx.publishEvent(event);
    }
}
