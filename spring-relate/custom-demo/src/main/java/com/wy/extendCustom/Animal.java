package com.wy.extendCustom;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname Animal
 * @Description 动物类
 * @Date 2020/5/21 2:24 下午
 */
@Data
public class Animal {

    private static final Logger logger = LoggerFactory.getLogger(Animal.class);
    /**
     * 高度
     */
    private Integer weight;
    /**
     * 宽度
     */
    private Integer height;

    /* step 这个方法可以理解为业务代码，在这里只是做一个简单展示而已，也便于理解
    * 像下面又出现了重复代码，每个方法，又有几行冗余代码，这种情况下，每个方法都要加，
    * 冗余代码会变的越来越多，不优雅，那怎么才可以进行优化呢，
    * 像我也问过其他人，再创建一个类，进行方法提取，在此每个方法中，调用新创建的那个类的方法，
    * 但是效果其实是一样的，因为这样的，在每个方法中还是会进行调用的，还是冗余代码，性质相同
    * 但是也有的人回复说使用面向切换编程来解决，俗称aop来实现，不入侵代码，便可以实现此性能监控需求
    *
    * 向下面这种情况，属于是横向切面编程，把每个方法都水平放置，便可以通过一刀切的方式，把这些位置都可以切出来，
    * 每个方法的那个位置，算一个点，由点到线，线成面，所以，这也就是aop是面向切面编程的思想。
    * */
    public void eat() {
        long start = System.currentTimeMillis();
        logger.info("性能监控开始时间 startTime:{}", start / 1000f);
        System.out.println(" --------eat--------");
        long end = System.currentTimeMillis();
        logger.info("性能监控方法耗时 time:{}", (end - start) / 1000f);
    }

    /* step 这个方法可以理解为业务代码*/
    public void run() {
        long start = System.currentTimeMillis();
        logger.info("性能监控开始时间 startTime:{}", start / 1000f);
        System.out.println("--------run--------");
        long end = System.currentTimeMillis();
        logger.info("性能监控方法耗时 time:{}", (end - start) / 1000f);
    }
}
