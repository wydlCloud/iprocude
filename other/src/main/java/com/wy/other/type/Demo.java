package com.wy.other.type;

import com.sun.tools.javadoc.Messager;

import java.lang.reflect.Member;

/**
 * @Classname Demo
 * @Description TODO
 * @Date 2020/9/23 2:18 下午
 * @Company 杭州光云科技有限公司
 * @Author yunze
 */
public class Demo {

    static boolean isContinusArray(int a[]) {
        int min = a[0];
        int max = a[0];
        for(int i = 1; i < a.length; i++) {
            if(a[i] < min && a[i] !=0 ) {
                min = a[i];
            }
            if(a[i] > max && a[i] != 0) {
                max = a[i];
            }
        }

        if((max - min) <= a.length-1 ) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        int array_1[] = {0,2,3,0,0};
        int array_2[] = {3,2,5,4,6};
        int array_3[] = {10,56,0,6,1};
        System.out.println("array_1是否为连续数组："+isContinusArray(array_1));
        System.out.println("array_2是否为连续数组："+isContinusArray(array_2));
        System.out.println("array_3是否为连续数组："+isContinusArray(array_3));
    }
}
