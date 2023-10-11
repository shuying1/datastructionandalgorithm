package com.iflytek.hsp.lanqiao;

import java.util.Calendar;

/**
 * @author yings
 * @create 2023-02-23 14:06
 */
public class Day20230223 {

    public static void main(String[] args) {
        shijiemori();
    }
    public static void shijiemori(){
        Calendar calendar=Calendar.getInstance();

        calendar.set(Calendar.MONTH,11);
        calendar.set(Calendar.DAY_OF_MONTH,31);

        for (int year = 1999; year < 10000; year+=100) {
            calendar.set(Calendar.YEAR,year);
            System.out.println(year+ " "+calendar.get(Calendar.DAY_OF_WEEK));
            if (calendar.get(Calendar.DAY_OF_WEEK)==1){
                break;
            }
        }
    }
}
