package com.wy.concurrent.lambada;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created on 2019/4/10.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2018
 * Company:
 *
 * @author wy
 */
public class StreamApi {


    public static void main(String[] args) {
        //测试数据
        List<Student> list = Arrays.asList(
                // name，age
                new Student("张三", 11),
                new Student("王五", 20),
                new Student("王五", 91),
                new Student("张三", 8),
                new Student("李四", 44),
                new Student("李四", 44),
                new Student("李四", 44)
        );
      /*  System.out.println("-------------jdk  8  之前----------------------------");
        //jdk8之前
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println("-------------jdk  8 lambda----------------------------");
        //jdk8 lambda
        list.forEach(x -> System.out.println(x));
        System.out.println("-------------java 8 stream lambda----------------------------");
        // java 8 stream lambda
        list.stream().forEach(x -> System.out.println(x));*/

      /*  System.out.println("-----排序前-----");
        list.forEach(student -> System.out.println(student));
        System.out.println("-----排序后-----");
        // java 8 前
        System.out.println("java 8 前");
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        for (Student student : list) {
            System.out.println(student);
        }
        // java 8 stream 方法引用
        System.out.println("java 8 stream 方法引用");
        list.stream().sorted(Comparator.comparing(Student::getAge)).forEach(user -> System.out.println(user));*/

      /*  // 输出年龄大于50的人
        System.out.println("-----过滤前-----");
        list.forEach(x -> System.out.println(x));
        System.out.println("-----过滤后-----");
        // java 8 前
        System.out.println("java 8 前");
        for(Student student: list){
            if (student.getAge() > 50) {
                System.out.println(student);
            }
        }
        // java 8 stream
        System.out.println("java 8 stream");
        list.stream().filter((Student student) -> student.getAge() > 50).forEach(user -> System.out.println(user));*/

       /* // 从第三个开始截断，只输出前三个
        System.out.println("-----截断前-----");
        list.forEach(user -> System.out.println(user));
        System.out.println("-----截断后-----");
        // java 8 前
        System.out.println("java 8 前");
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i));
        }
        // java 8 stream
        System.out.println("java 8 stream");
        list.stream().limit(3).forEach(user -> System.out.println(user));*/

      /*  // 跳过前三个元素，从第四个开始输出
        System.out.println("-----跳过前-----");
        list.forEach(x -> System.out.println(x));
        System.out.println("-----跳过后-----");
        // java 8 前
        System.out.println("java 8 前");
        for (int i = 3; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // java 8 stream
        System.out.println("java 8 stream");
        list.stream().skip(3).forEach(x -> System.out.println(x));*/

        // 因为Arrays.asList() 返回的是Arrays的内部类ArrayList，操作remove，add会报错
      /*  List<Student> students = new ArrayList(list);
        // 为list去除重复数据
        System.out.println("-----去重前-----");
        list.forEach(user -> System.out.println(user));
        System.out.println("-----去重后-----");
        // java 8 前
        System.out.println("java 8 前");
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = students.size() - 1; j > i; j--) {
                if (students.get(j).getAge().equals(students.get(i).getAge()) && students.get(j).getName()
                        .equals(students.get(i).getName())) {
                    students.remove(i);
                }
            }
        }
        for (Student student : students) {
            System.out.println(student);
        }
        // java 8 stream
        System.out.println("java 8 stream");
        students.stream().distinct().forEach(x -> System.out.println(x));
*/

        /*  *
         * 去重+按照年龄大于40以后从小到大+只取前二
         */
        list.stream().distinct().filter(x -> x.getAge() > 40).sorted(
                Comparator.comparing(Student::getAge)).limit(2).forEach(user -> System.out
                .println(user));
    }


       /* IntSummaryStatistics num = list.stream().mapToInt(u -> u.getAge())
                .summaryStatistics();
        System.out.println("总共人数：" + num.getCount());
        System.out.println("平均年龄：" + num.getAverage());
        System.out.println("最大年龄：" + num.getMax());
        System.out.println("最小年龄：" + num.getMin());
        System.out.println("年龄之和：" + num.getSum());

    }*/

    // 只输出所有人的年龄
      /*  System.out.println("------------映射前 输出所有人的年龄和姓名-----");
        list.stream().forEach(x -> System.out.println(x));
        System.out.println("-------------映射后----------------------------");
        List<Integer> ages = list.stream().map(user -> user.getAge()).collect(toList());
        ages.forEach(age -> System.out.println(age));

        // 小写转大写
        List<String> words = Arrays.asList("aaa", "vvvv", "cccc");
        System.out.println("------------------全部大写----------------------");
        List<String> collect = words.stream().map(s -> s.toUpperCase()).collect(toList());
        collect.forEach(s -> System.out.println(s));*/

       /* //创建一个 装有两个泛型为integer的集合
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5));
        // 将两个合为一个
        Stream<Integer> integerStream = stream.flatMap(
                (Function<List<Integer>, Stream<Integer>>) integers -> integers.stream());
        // 为新的集合
        List<Integer> collect = integerStream.collect(toList());
        System.out.println("新stream大小:"+collect.size());
        System.out.println("-----合并后-----");
        collect.forEach(o -> System.out.println(o));*/

       /* Student student = list.stream().findFirst().get();
        System.out.println(student);*/
//根据多个字段进行去重操作

    // 根据三个字段去重
/*    List<Person> lst = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(
                            () -> new TreeSet<>(Comparator.comparing(o -> o.getName() + "#" + o.getAge() + "#" + o.getAddress()))),
                            ArrayList::new));*/


}
