package cn.com.chnsys.lambda;

import cn.com.chnsys.pojo.Employee;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

/**
 * @Class: TestLambda2
 * @description:   练习
 * @Author: hongzhi.zhao
 * @Date: 2019-07-25 15:35
 */
public class TestLambda2 {

    List<Employee> employeeList = Arrays.asList(
            new Employee(1,"张三",18,9999.99),
            new Employee(2,"李四",59,6666.66),
            new Employee(3,"王五",28,3333.33),
            new Employee(4,"赵六",8,7777.77),
            new Employee(5,"田七",38,5555.55)
    );

    //按照年龄排序，如果年龄一样按照姓名排序
    @Test
    public void test(){

//        Collections.sort(employeeList, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return 0;
//            }
//        });
        employeeList.stream()
                .forEach(System.out::print);

//        Collections.sort(employeeList,(e1,e2)->{
//            if (e1.getAge()==e2.getAge()){
//                return e1.getName().compareTo(e2.getName());
//            }else {
//                return Integer.compare(e1.getAge(),e2.getAge());
//            }
//        });

        Collections.sort(employeeList,(e1,e2)-> -Integer.compare(e1.getAge(), e2.getAge()));

        employeeList.stream()
                .forEach(System.out::println);
    }
}
