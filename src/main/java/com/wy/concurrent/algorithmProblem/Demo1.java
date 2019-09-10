package com.wy.concurrent.algorithmProblem;

import java.util.Scanner;

/**
 * Created on 2019/9/10.
 * Title: Simple
 * Description:
 * 李雷和韩梅梅坐前后排，上课想说话怕被老师发现，所以改为传小纸条。为了不被老师发现他们纸条上说的是啥，他们约定了如下方法传递信息：
 * 将26个英文字母（全为大写），外加空格，一共27个字符分成3组，每组9个。也就是ABCDEFGHI是第一组，JKLMNOPQR是第二组，STUVWXYZ*是第三组（此处用*代表空格）。
 * 然后根据传递纸条那天的日期，改变字母的位置。
 * 先根据月份数m，以整个分组为单位进行循环左移，移动(m-1)次。
 * 然后根据日期数d，对每个分组内的字符进行循环左移，移动(d-1)次。
 * 以3月8日为例，首先移动分组，3月需要循环左移2次，变成：
 * STUVWXYZ*，ABCDEFGHI，JKLMNOPQR
 * 然后每组内的字符，8日的话需要循环左移7次，最终的编码为：
 * Z*STUVWXY，HIABCDEFG，QRJKLMNOP
 * 对于要传递信息中的每个字符，用组号和组内序号两个数字来表示。
 * 如果在3月8日传递信息“HAPPY”，那么H位于第2组的第1个，A位于第2组第3个，P位于第3组第9个，Y位于第1组第9个，所以纸条上会写成：
 * 21 23 39 39 19
 * 现在给定日期和需要传递的信息，请输出应该写在纸条上的编码。
 * <p>
 * 输入规范：
 * 每个输入包含两行。第一行是用空格分隔的两个数字，第一个数字是月份，第二个数字是日子。输入保证是一个合法的日期。
 * 第二行为需要编码的信息字符串，仅由A~Z和空格组成，长度不超过1024个字符。
 * <p>
 * 输出规范：
 * 对每个输入，打印对应的编码，数字之间用空格分隔，每个输出占一行。
 * <p>
 * 输入示例1:
 * 1 1
 * HI
 * 输出示例1:
 * 18 19
 * <p>
 * 输入示例2:
 * 3 8
 * HAPPY
 * 输出示例2:
 * 21 23 39 39 19
 * <p>
 * 输入示例3:
 * 2 14
 * I LOVE YOU
 * 输出示例3:
 * 35 25 18 12 29 31 25 23 12 28
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Demo1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String date = input.nextLine();
        int month = Integer.parseInt(date.split(" ")[0]);
        int day = Integer.parseInt(date.split(" ")[1]);
        String content = input.nextLine();

        String[] codeTable = {"ABCDEFGHI", "JKLMNOPQR", "STUVWXYZ*"};

        int indexMon = month - 1;
        int indexDay = day - 1;

        char[] charArrOne = codeTable[0].toCharArray();
        char[] charArrTwo = codeTable[1].toCharArray();
        char[] charArrThree = codeTable[2].toCharArray();

        // 因为每一组的里的每个元素都会向左移动(d-1)次，故而先移动组内元素
        charArrOne = toCharArray(charArrOne, indexDay);
        charArrTwo = toCharArray(charArrTwo, indexDay);
        charArrThree = toCharArray(charArrThree, indexDay);

        // 将组内移动完成的元素组成新的数组
        codeTable[0] = new String(charArrOne);
        codeTable[1] = new String(charArrTwo);
        codeTable[2] = new String(charArrThree);

        // 再整体移动每组元素
        codeTable = toStringArray(codeTable, indexMon);

        char[] contentArray = content.toCharArray();

        //把空格换位*
        for (int i = 0; i < contentArray.length; i++) {
            if (contentArray[i] == ' ') {
                contentArray[i] = '*';
            }
        }
        // 将数组转为一个char数组，循环对比用户输入的内容
        String strs = new String(codeTable[0]) + new String(codeTable[1]) + new String(codeTable[2]);
        char[] strArr = strs.toCharArray();

        String str = "";
        for (int i = 0; i < contentArray.length; i++) {
            for (int j = 0; j < strArr.length; j++) {
                // 当用户输入的字符等于第一组中元素时，输出1+（j下标0开始到8结束 ，需加1）
                if (contentArray[i] == strArr[j] && j < 9) {
                    str = str + "1" + (j + 1) + " ";
                }
                // 当用户输入的字符等于第二组中元素时，输出2+（j下标9开始到17结束 ，需加1再减9，即j-8）
                if (contentArray[i] == strArr[j] && j < 18 && j >= 9) {
                    str = str + "2" + (j - 8) + " ";
                }
                // 当用户输入的字符等于第三组中元素时，输出3+（j下标19开始到26结束 ，需加1再减18，即j-17）
                if (contentArray[i] == strArr[j] && j < 27 && j >= 18) {
                    str = str + "3" + (j - 17) + " ";
                }
            }
        }

        System.out.println(str);

    }

    public static char[] toCharArray(char[] strArr, int index) {
        while (index > 0) {
            char temp = strArr[0];
            for (int i = 0; i < strArr.length; i++) {
                if (i < strArr.length - 1) {
                    strArr[i] = strArr[i + 1];
                }
                if (i == strArr.length - 1) {
                    strArr[i] = temp;
                }
            }
            index--;
        }
        return strArr;
    }

    public static String[] toStringArray(String[] strArr, int index) {
        while (index > 0) {
            String temp = strArr[0];
            for (int i = 0; i < strArr.length; i++) {
                if (i < strArr.length - 1) {
                    strArr[i] = strArr[i + 1];
                }
                if (i == strArr.length - 1) {
                    strArr[i] = temp;
                }
            }
            index--;
        }
        return strArr;
    }
}
