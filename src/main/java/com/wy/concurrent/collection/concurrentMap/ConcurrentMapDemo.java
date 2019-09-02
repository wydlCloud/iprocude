package com.wy.concurrent.collection.concurrentMap;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created on 2019/9/2.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class ConcurrentMapDemo {


    final static HashMap<String, String> map = new HashMap<String, String>(2);

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "moon" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();
    }

}
