package cn.com.chnsys.Stream;

import cn.com.chnsys.pojo.Employee;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @Class: TestStreamApi
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-26 15:25
 *
 * 中间操作：
 * 筛选与切片
 * filter-接受Lambda，从流中排除某些元素
 * limit 截断流 使其元素不超过给定数量
 * skip（n） 跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足N个，则返回一个空的流，与Limnt互补
 * distinct（筛选） 通过流所生成的元素的hashCode和equals去除重复元素
 *
 */
public class TestStreamApi {
    List<Employee> employeeList = Arrays.asList(
            new Employee(1,"张三",18,9999.99),
            new Employee(2,"李四",59,6666.66),
            new Employee(3,"王五",28,3333.33),
            new Employee(4,"赵六",8,7777.77),
            new Employee(5,"田七",38,5555.55),
            new Employee(5,"田七",38,5555.55)
    );
    @Test
    public void test(){
//        List<Employee> collect = employeeList.stream()
//                .filter(e -> e.getAge() > 30)
//                .collect(Collectors.toList());

//         employeeList.stream()
//                .filter(e -> e.getSalary() >= 3000)
//                 .distinct()
//                 .forEach(System.out::println);
        List<Employee> collect = employeeList.stream()
                .filter(e -> e.getSalary() >= 5000)
                .distinct()

                .collect(Collectors.toList());


        collect.stream()
                .forEach(e-> System.out.println(e));


    }
}

