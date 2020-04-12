package com.wy.other.Initialize;

/**
 * Created on 2018/7/29.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2018
 * Company:
 *
 * @author wy
 */

public class Test {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        a2 = a1;
        for (int i = 0; i < a2.length; i++) {
            //a2[i]++;
            a2[i] = a2[i] + 1;
        }
        for (int i = 0; i < a1.length; i++) {
            prt("a1[" + i + "]" + a1[i]);
        }
    }

    static void prt(String s) {
        System.out.println(s);
    }
}
