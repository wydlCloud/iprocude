package com.wy.concurrent.designpattern.chainOfPattern;

/**
 * Created on 2019/9/14.
 * Title: Simple
 * Description:文件处理器
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File Console::Logger"+message);
    }
}
