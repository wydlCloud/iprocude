package com.wy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LemonadeChange860
 * @Description 柠檬水找零
 * <p>
 * <p>
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * <p>
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lemonade-change
 * @Date 2020/12/10 5:51 下午
 * @Company 杭州光云科技有限公司
 * @Author yunze
 */
public class LemonadeChange860 {
    //
//    输入：[5,5,5,10,20]
//    输出：true
//    解释：
//    前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
//    第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
//    第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
//    由于所有客户都得到了正确的找零，所以我们输出 true。
    // 时间复杂度是O(n),空间复杂度是O(1)
    public static boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> money = new HashMap<Integer, Integer>();
        money.put(5, 0);
        money.put(10, 0);
        money.put(20, 0);
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                money.put(5, money.get(5) + 1);
            } else if (bills[i] == 10) {
                if (money.get(5) >= 1) {
                    money.put(5, money.get(5) - 1);
                    money.put(10, money.get(10) + 1);
                } else {
                    return false;
                }
            } else {
                if (money.get(5) >= 1 && money.get(10) >= 1) {
                    money.put(5, money.get(5) - 1);
                    money.put(10, money.get(10) - 1);
                    money.put(20, money.get(20) + 1);
                } else if (money.get(5) >= 3) {
                    money.put(5, money.get(5) - 3);
                    money.put(20, money.get(20) + 1);
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    // 时间复杂度是O(n)  空间复杂度是O(1)   模拟 + 贪心
    public static boolean lemonadeChange1(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 5, 10, 20};
        boolean b = lemonadeChange(nums);
        System.out.println(b);
    }

}
