package com.wy.other.collection.failfast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/8/24.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class FailFastTest {


    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        for (int i=1;i<10000;i++){
            list.add("fail-fast"+i);
        }


        new Thread(()->{
            for (String s:list){
                System.out.println(s);
            }
        }).start();
        new Thread(()->{
            try {
                Thread.sleep(10);
                list.add("fail-fast"+1001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
