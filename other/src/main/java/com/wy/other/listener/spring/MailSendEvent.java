package com.wy.other.listener.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author wy
 * @company
 * @Classname MailSendEvent
 * @Description 事件对象
 * @Date 2020/4/1 10:36 下午
 */

public class MailSendEvent extends ApplicationContextEvent {
    private String to;
    public MailSendEvent(ApplicationContext source,String to) {
        super(source);
        this.to=to;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
