package com.wy.concurrent.interceptorTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/4/12.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2018
 * Company:
 *
 * @author wy
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Value("1")
    private Long id;
    @Value("管理者")
    private String roleName;
    @Value("管理者筆記")
    private String note;
    //TODO 註解@Component代表Spring Ioc会把这个类扫描生成Bean实例，而其中的value属性代表这个类在Spring中的id，这就
    //TODO 相当于XML方式定义的Bean的id，也可以简写成@Component（"role"）,或者是@Component，对于不写的情况，则ioc容器就默认类名，
    //TODO 但是以首字母小写的形式作为id，为其生成对象，配置到容器中。
    //TODO 注解@Value代表的是值得注入，这里只是简单注入一些值，其中id是一个long型，注入的时候Spring会为其转型类型。
    //TODO 现在有个这个类，但是IOC并不知道去哪里去扫描对象，这个时候可以使用config来告诉它，
}
