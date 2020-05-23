package com.wy.designpattern.chainOfPattern;

/**
 * Created on 2019/9/14.
 * Title: Simple
 * Description:error日志处理器
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }

}
