package com.wy.newFeature;

import java.text.SimpleDateFormat;
import java.util.*;

public class Java8 {

    public static void main(String[] args) {
        try {
            System.out.println("test2");
            List<String> dateList = new ArrayList<>();
            dateList.add("2019-03-05");
            dateList.add("2019-03-06");
            dateList.add("2019-03-07");
            dateList.add("2019-03-27");
            dateList.add("2019-03-28");
            dateList.add("2019-03-29");
            dateList.add("2019-03-30");
            dateList.add("2019-03-31");
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
                if ((dates.get(i).getTime() - dates.get(i - 1).getTime()) / (1000 * 60 * 60 * 24) == 1) {
                    count++;
                    if (count > 4) {
                        System.out.println("已经连续休假超过4天啦！");
                        // return true;
                    } else {
                        System.out.println("连续休假" + count + "天");
                    }
                } else {
                    count = 1;
                }
            }
            // return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
