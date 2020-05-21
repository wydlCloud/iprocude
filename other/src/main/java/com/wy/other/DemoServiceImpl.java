package com.wy.other;

import org.springframework.stereotype.Service;

/**
 * @author wy
 * @company 中国网络科技
 * @Classname DemoServiceImpl
 * @Description TODO
 * @ 2020/4/14 5:05 下午
 */
public class DemoServiceImpl {
    public long test(){
        return 100L/0;
    }
}
