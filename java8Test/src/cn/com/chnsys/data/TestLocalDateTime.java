package cn.com.chnsys.data;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.junit.Test;

/**
 * @Class: TestLocalDateTime
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-30 11:53
 */
public class TestLocalDateTime {

    //1.LocalDate(日期) LocalTime（时间）LocalDateTime（日期时间）

    @Test
    public void trest1(){
        //获取系统时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //设置时间
        LocalDateTime localDateTime1 = LocalDateTime.of(2015,10,10,12,12,34,12);
        System.out.println(localDateTime1);

        //对时间进行运算
        //加一年，还有时，分，秒，周，纳秒，毫秒等
        LocalDateTime localDateTime2 = localDateTime.plusYears(12);
        System.out.println(localDateTime2);
        LocalDateTime localDateTime3 = localDateTime.minusYears(2);
        System.out.println(localDateTime3);

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println(dayOfWeek.toString());
    }


    //2.Instant 时间戳（以unix 元年  1970年1月1日00:00:00 到某个时间之间的毫秒值）
    @Test
    public void test1(){
        Instant instant = Instant.now();   //默认获取UTC 时区(美国使用的时间)
        System.out.println(instant);
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));//美国和中国相差8个小时，进行运算
        System.out.println(offsetDateTime);
        System.out.println(instant.toEpochMilli()); //转化成毫秒值
        Instant instant1 = Instant.ofEpochSecond(1000);
        System.out.println(instant1);   //1970-01-01T00:16:40Z   在1970年00:00:00 加上1000秒
    }

    //3.Duration 计算两个时间的间隔
    //     Period   计算两个日期之间的间隔

    @Test
    public void test2(){
        Instant instant = Instant.now();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant1 = Instant.now();
        Duration between = Duration.between(instant, instant1);
        System.out.println(between.toMillis());
        System.out.println(between.getSeconds());
        System.out.println("---------------------------");
        LocalTime localTime = LocalTime.now();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime localTime1 = LocalTime.now();
        System.out.println(Duration.between(localTime,localTime1).toMillis());

        LocalDate localDate = LocalDate.of(2018,8,8);
        LocalDate localDate1 = LocalDate.now();
        Period between1 = Period.between(localDate, localDate1);
        System.out.println(between1);
        System.out.println(between1.getYears());
        System.out.println(between1.getMonths());
        System.out.println(between1.getDays());

    }

}
