package cn.com.chnsys.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * @Class: TestDateTimeFormatter
 * @description: 格式化时间
 * @Author: hongzhi.zhao
 * @Date: 2019-07-31 09:34
 */
public class TestDateTimeFormatter {

    //DateTimeFormatter
    @Test
    public void test(){
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(isoDateTime);
        System.out.println(format);

        DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
        String format1 = localDateTime.format(isoDate);//1
        System.out.println(format1);

        System.out.println("-------------------------");
        //自定义的
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format2 = localDateTime.format(dateTimeFormatter);
        System.out.println(format2);


        //解析会来
        LocalDateTime localDateTime1 = LocalDateTime.parse(format2,dateTimeFormatter);//2
        System.out.println(localDateTime1);
    }
}
