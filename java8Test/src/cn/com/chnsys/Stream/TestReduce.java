package cn.com.chnsys.Stream;

import cn.com.chnsys.pojo.Employee;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

/**
 * @Class: TestReduce
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-29 11:55
 *
 * count()
 * max()
 * min()
 * foreach()
 */
public class TestReduce {

    List<Employee> employeeList = Arrays.asList(
            new Employee(1,"张三",18,9999.99),
            new Employee(2,"李四",18,6666.66),
            new Employee(3,"王五",28,3333.33),
            new Employee(4,"赵六",8,7777.77),
            new Employee(5,"田七",38,5555.55)
    );
    @Test
    public void test(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);

        //returce(( T identity ,BinaryOperator)  第一个参数为起始值从什么开始
        Integer num = list.stream()
                .reduce(0,(x,y)->x+y);
        //上面的第一个0作为x
        System.out.println(num);

        employeeList.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        int sum = employeeList.stream()
                .mapToInt(Employee::getAge).sum();

        long count = employeeList.stream()
                .count();

        Optional<Employee> max = employeeList.stream()
                .max(Comparator.comparing(Employee::getAge));




    }
}
