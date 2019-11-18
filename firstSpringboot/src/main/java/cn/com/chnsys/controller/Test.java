package cn.com.chnsys.controller;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.SchemaOutputResolver;
import org.omg.CORBA.NameValuePair;
import org.springframework.http.HttpEntity;

/**
 * @Class: Test
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-11 12:49
 */
public class Test {

//    public static void main(String[] args) {
//        Instant ins1=Instant.now();
//        try {
//            Thread.sleep(1000);
//        }catch(InterruptedException e) {
//
//        }
//        Instant ins2=Instant.now();
//        Duration duration=Duration.between(ins1, ins2);
//        System.out.println(duration.toDays());


    public static void main(String[] args) {

        String nowDateStr = LocalDateTime.now().toString();
        System.out.println(nowDateStr);//2018-03-27

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //不现实毫秒
        System.out.println(LocalDateTime.now().withNano(0));
        System.out.println(LocalDateTime.now().withYear(1));

        System.out.println(LocalDateTime.of(2019,6,8,11,11,11));
        //当前时间加上2小时
        System.out.println(LocalDateTime.now().plusHours(2));

        LocalDateTime localDateTime1 = LocalDateTime.of(2019,6,8,11,11,11);
        LocalDateTime today = LocalDateTime.now();
        System.out.println(localDateTime1.until(today,ChronoUnit.MINUTES));

    }

}





