package cn.com.chnsys.Stream;

import cn.com.chnsys.pojo.Employee;
import java.awt.geom.Ellipse2D;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

/**
 * @Class: SortedStream
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-29 10:09
 *
 * 中间操作
 * sorted()自然排序 （conparable）
 * sorted（）定制排序（compaqrator）
 */
public class SortedStream {
    List<String> list = Arrays.asList("fff","bbb","adv","ddd","eee");

    List<Employee> employeeList = Arrays.asList(
            new Employee(1,"张三",18,9999.99),
            new Employee(2,"李四",18,6666.66),
            new Employee(3,"王五",28,3333.33),
            new Employee(4,"赵六",8,7777.77),
            new Employee(5,"田七",38,5555.55)
    );

    @Test
    public void test(){

        //过去 得到最大值
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return -Integer.compare(o1.getAge(),o2.getAge());
            }
        });
        System.out.println(employeeList.get(0));

        //用Lambda表达式
        Collections.sort(employeeList,(e1,e2)->{
            return -Integer.compare(e1.getAge(),e2.getAge());
        });

        //用Stream
        employeeList.stream().
                sorted(Comparator.comparing(Employee::getAge)).
                forEach(System.out::println);

        Optional<Employee> max = employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary));
        Employee employee = max.get();

        list.stream().
                sorted().
                forEach(System.out::println);

        //如果用倒叙，加-号
        employeeList.stream().
                sorted((e1,e2)->{
                    if (e1.getAge()==e2.getAge()){
                        return -e1.getName().compareTo(e2.getName());
                    }else {
                        return -Integer.compare(e1.getAge(),e2.getAge());
                    }
                }).
                forEach(System.out::println);


    }





}
