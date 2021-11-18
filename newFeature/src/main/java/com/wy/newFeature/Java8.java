package com.wy.newFeature;

import java.text.SimpleDateFormat;
import java.util.*;

public class Java8 {

    public static void main(String[] args) {
        try {
            List<String> dateList = new ArrayList<>();
//            dateList.add("2020-12-28");
//            dateList.add("2020-12-29");
//            dateList.add("2020-12-31");
//            dateList.add("2020-12-31");
//            dateList.add("2021-01-01");
//            dateList.add("2021-01-02");
//            dateList.add("2021-01-03");
            dateList.add("2020-12-20");
            dateList.add("2020-12-21");
            dateList.add("2020-12-22");
            dateList.add("2020-12-31");
            dateList.add("2021-01-01");
            dateList.add("2021-01-03");
            dateList.add("2021-01-06");
            // 左开右闭
            List<String> strings = dateList.subList(6, 7);
            System.out.println(strings);

            // step1 判断是否有赠送积分的操作，如果有，必然不满足连续7天
            // step2 如果没有 则判断此7条数据日期是否连续7天
            // 满足7天，则赠送积分
            // 不满足7天，则结束
            List<Date> dates = new ArrayList<>();
            for (String date : dateList) {
                Calendar calendarTo = Calendar.getInstance();
                calendarTo.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                Calendar c = Calendar.getInstance();
                c.setTimeInMillis(0);
                c.set(calendarTo.get(Calendar.YEAR), calendarTo.get(Calendar.MONTH),
                        calendarTo.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                dates.add(c.getTime());
            }
            int count = 1;
            for (int i = dates.size() - 1; i > 0; i--) {
                long time = dates.get(i).getTime();
                long time1 = dates.get(i - 1).getTime();
                if ((time - time1) / (1000 * 60 * 60 * 24) == 1) {
                    count++;
                    if (count == 7) {
                        System.out.println("已经连续7天啦！");
//                         return true;
                    }
//                    else {
//                        System.out.println("连续休假" + count + "天");
//                    }
                } else {
                    break;
                }
//                else {
//                    count = 1;
//                }
            }
            System.out.println(count);
            String s = dateList.get(count - 1);
            System.out.println(s);
            // return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
