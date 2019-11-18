package cn.com.chnsys.Stream;

import cn.com.chnsys.pojo.Employee;
import cn.com.chnsys.pojo.EmployeeNew;
import cn.com.chnsys.pojo.EmployeeNew.Status;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;
import org.junit.Test;

/**
 * @Class: TestCollect
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-29 14:06
 */
public class TestCollect {

    //collect 将流转化成其他形式，接收一个Collect’or接口的实现，用于给Stream元素做汇总的方法
    //collector  被称为收集齐
    List<Employee> employeeList = Arrays.asList(
            new Employee(1,"张三",18,9999.99),
            new Employee(2,"李四",18,6666.66),
            new Employee(3,"王五",28,3333.33),
            new Employee(4,"赵六",8,7777.77),
            new Employee(5,"田七",38,5555.55)
    );


    List<EmployeeNew> employeeList1 = Arrays.asList(
            new EmployeeNew(1,"张三",18,9999.99,Status.FREE),
            new EmployeeNew(2,"李四",59,6666.66,Status.BUSY),
            new EmployeeNew(3,"王五",28,3333.33,Status.VOCATION),
            new EmployeeNew(4,"赵六",8,7777.77, Status.FREE),
            new EmployeeNew(5,"田七",38,5555.55,Status.BUSY)
    );
    @Test
    public void test(){

        //转成集合
        List<Employee> collect = employeeList.stream()
                .filter(e -> e.getSalary() > 80.0)
                .collect(Collectors.toList());

        //转成特殊的形式  Collectors 中的toCollection（）
        HashSet<String> hs =  employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hs.stream().forEach(System.out::print);
    }

    @Test
    public void test1() {
        long sizxe = employeeList.stream()
                .collect(Collectors.counting());

        double avi = employeeList.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(avi);


        //工资最多的一个人
        Optional<Employee> max = employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary));

        OptionalDouble min = employeeList1.stream()
                .mapToDouble(Employee::getSalary).min();

        employeeList.stream()
                .min(Comparator.comparing(Employee::getAge));

        //求最大的年龄
        OptionalInt max1 = employeeList.stream()
                .mapToInt(Employee::getAge).min();

        System.out.println(max1.getAsInt());

        employeeList.stream()
                .map(Employee::getAge)
                .reduce(Integer::sum);

    }

    @Test
    public void test2(){
        //分组
        Map<Integer, List<Employee>> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getAge));

        map.forEach((k,v)->{
            System.out.println("key:"+k+"  "+"value:"+v);
        });

        Map<Status, Map<String, List<EmployeeNew>>> collect = employeeList1.stream().
                collect(Collectors.groupingBy(EmployeeNew::getStatus, Collectors.groupingBy(e -> {
                    if (((EmployeeNew) e).getAge() <= 35) {
                        return "青年";
                    } else
                        return "老年";
                })));
        System.out.println(collect);

        //链接字符串
        String str = employeeList1.stream()
                .map(EmployeeNew::getName)
                .collect(Collectors.joining(",","",":"));

        System.out.println(str);
    }

    @Test
    public void test8(){
        String collect = employeeList1.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(collect);
    }


}
