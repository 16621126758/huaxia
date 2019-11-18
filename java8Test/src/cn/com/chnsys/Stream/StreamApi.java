package cn.com.chnsys.Stream;

import cn.com.chnsys.pojo.Employee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @Class: StreamApi
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-26 14:39
 *
 * Stream 的三个操作步骤 1.创建Stream 2.中间操作 3.终止操作
 */
public class StreamApi {


    @Test
    public void test() {
        //1.可以通过Collection集合提供的stream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2.通过Arrays中的静态方法Stream收到数组刘
        Employee[] employees = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);

        //3.通过Stream中的静态方法of
        Stream.of("aa", "bb", "cc").forEach(System.out::println);




    }

}
