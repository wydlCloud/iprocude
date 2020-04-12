package com.wy.other.listener.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname MailSendListener1
 * @Description TODO
 * @Date 2020/4/1 11:29 下午
 */

public class MailSendListener1  implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        System.out.println(applicationContext);
    }
}
