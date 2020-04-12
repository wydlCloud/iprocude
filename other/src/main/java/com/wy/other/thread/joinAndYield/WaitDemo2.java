package com.wy.other.thread.joinAndYield;

/**
 * Created on 2019/8/27.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class WaitDemo2 implements Runnable {
    @Override
    public synchronized void run() {
        notify();
    }
}
