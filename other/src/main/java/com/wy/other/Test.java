package com.wy.other;

import java.util.Scanner;

/**
 * Created on 2019/8/29.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Test {

    /**
      * ip地址转成long型数字
      * 将IP地址转化成整数的方法如下：
      * 1、通过String的split方法按.分隔得到4个长度的数组
      * 2、通过左移位操作（<<）给每一段的数字加权，第一段的权为2的24次方，第二段的权为2的16次方，第三段的权为2的8次方，最后一段的权为1
      * @param string
      * @return
      */
    public  static  long ipToLong(String string){
        String[]ip = string.split("\\.");
        return (Long.parseLong(ip[0]) << 24) + (Long.parseLong(ip[1]) << 16) + (Long.parseLong(ip[2]) << 8)+
                Long.parseLong(ip[3]);

    }


    public static void main(String[] args) {
        //使用Scanner从样例输入（标准输入流）中获取输入数据，示例如下：
        ////（包括但不限于下列情况）
        System.out.println("请输入IP:");
        Scanner in = new Scanner(System.in);
        //int x = in.nextInt(); ---取整数
        String s = in.next();


        //你的代码
        long ipToLong = ipToLong(s);

        //根据样例输出的格式，输出你的结果，示例如下：
        //System.out.println(...);
        System.out.println(ipToLong);
     /*   System.out.println(ipToLong("10.0.3.193"));*/
    }



}
