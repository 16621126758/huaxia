package cn.com.chnsys.data;

import java.sql.SQLOutput;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @Class: TestTemporalAjjuster
 * @description:时间校正器
 * @Author: hongzhi.zhao
 * @Date: 2019-07-30 16:42
 */
public class TestTemporalAjjuster {

    public static void main(String[] args) {
        //TemporalAjuster
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //指定为10号  这个只能指定，当我们需要计算的时候不适合
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);
        System.out.println(localDateTime1);

        //第一天
        LocalDateTime with = localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(with);
        //下个月第一天
        LocalDateTime with1 = localDateTime.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(with1);
        //下个周日
        LocalDateTime with2 = localDateTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(with2);

        //自定义：下一个工作日
        LocalDateTime with3 = localDateTime.with(e -> {
            LocalDateTime localDateTime2 = (LocalDateTime) e;
            DayOfWeek dayOfWeek = localDateTime2.getDayOfWeek();
            System.out.println(dayOfWeek);
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return localDateTime2.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return localDateTime2.plusDays(2);
            } else {
                return localDateTime2.plusDays(1);
            }
        });
        System.out.println(with3);


    }

}
