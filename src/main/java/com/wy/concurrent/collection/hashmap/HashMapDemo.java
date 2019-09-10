package com.wy.concurrent.collection.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2019/9/10.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class HashMapDemo {

    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"1"+1);
     /* for (int i=0;i<=10000;i++){
          map.put(i,i+"---"+i);
      }
        System.out.println(map);*/
    }
}
