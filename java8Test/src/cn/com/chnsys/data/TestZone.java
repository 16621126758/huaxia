package cn.com.chnsys.data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import org.junit.Test;

/**
 * @Class: TestZone
 * @description:时区的操作
 * @Author: hongzhi.zhao
 * @Date: 2019-07-31 10:27
 */
public class TestZone {
    //ZonedDate    ZonedTime ZoedDateTime
    @Test
    public void test(){
        //获取所有的时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Caracas"));
        System.out.println(localDateTime);

        //指定一个带时区的时间
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);

    }
}
