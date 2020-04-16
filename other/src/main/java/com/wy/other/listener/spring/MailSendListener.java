package com.wy.other.listener.spring;

import org.springframework.context.ApplicationListener;

/**
 * @author wy
 * @company
 * @Classname MailSendListener
 * @Description 事件监听器
 * @Date 2020/4/1 10:37 下午
 */

public class MailSendListener implements ApplicationListener<MailSendEvent> {
    @Override
    public void onApplicationEvent(MailSendEvent mailSendEvent) {
        MailSendEvent mailSendEvent1 = mailSendEvent;
        System.out.println("MailSendListener:向" + mailSendEvent1.getTo() + "发送完一封邮件");
    }
}
