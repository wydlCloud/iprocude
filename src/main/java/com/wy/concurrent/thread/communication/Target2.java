package com.wy.concurrent.thread.communication;

/**
 * Created on 2019/8/26.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Target2 implements Runnable {
    private Demo2 demo2;

    @Override
    public void run() {
        demo2.setSignal(1);
    }

    public Target2(Demo2 demo2) {
        this.demo2 = demo2;
    }
}
