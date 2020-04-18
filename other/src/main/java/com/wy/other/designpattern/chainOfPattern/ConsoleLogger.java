package com.wy.other.designpattern.chainOfPattern;

/**
 * Created on 2019/9/14.
 * Title: Simple
 * Description:控制台处理器
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger :" + message);
    }
}