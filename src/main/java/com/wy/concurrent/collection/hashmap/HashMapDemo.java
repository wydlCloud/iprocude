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
//        Map<Integer,String> map=new HashMap<>();
//        map.put(1,"1"+1);
     /* for (int i=0;i<=10000;i++){
          map.put(i,i+"---"+i);
      }
        System.out.println(map);*/
     // 测试自定义类重写equals和hashcode值
//        Student student=new Student();
//        student.setName("小明");
//        student.setAge(18);
//        Student student1=new Student();
//        student1.setName("小明");
//        student1.setAge(18);
//        HashMap<Student, String> map = new HashMap<>();
//        map.put(student, "wy");
//        map.put(student1, "yw");
//        System.out.println(map.get(student));
//        System.out.println(map.get(student1));
//        System.out.println(student.equals(student1));

        // 测试扩容resize
        HashMap<Integer, Integer> integerIntegerHashMap=new HashMap<>();
        for (int i=0;i<12;i++){
            integerIntegerHashMap.put(i,i);
        }
        integerIntegerHashMap.put(12,12);
        for (Integer x : integerIntegerHashMap.keySet()) {
            System.out.println(x.intValue());
        }



    }
}
