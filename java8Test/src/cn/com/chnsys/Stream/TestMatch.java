package cn.com.chnsys.Stream;

import cn.com.chnsys.pojo.Employee;
import cn.com.chnsys.pojo.EmployeeNew;
import cn.com.chnsys.pojo.EmployeeNew.Status;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import org.junit.Test;

/**
 * @Class: TestMatch
 * @description:终止操作
 * @Author: hongzhi.zhao
 * @Date: 2019-07-29 10:49
 *
 * 查找与匹配
 * alLMatch 检查是否匹配所有元素
 * anyMatch 检查是否匹配一个元素
 * noneMatch 检查是否没有匹配的元素
 * findFirst 返回第一个元素
 * count    参会流中元素的个数
 * max      返回流中的最大值
 * min      返回流中的最小值
 */
public class TestMatch {

    List<EmployeeNew> employeeList = Arrays.asList(
            new EmployeeNew(1,"张三",18,9999.99,Status.FREE),
            new EmployeeNew(1,"lisi",18,9999.99,Status.FREE),
            new EmployeeNew(1,"wangwu",18,9999.99,Status.FREE),
            new EmployeeNew(1,"zhaoliu",18,9999.99,Status.FREE),
            new EmployeeNew(2,"李四",59,6666.66,Status.BUSY),
            new EmployeeNew(3,"王五",28,3333.33,Status.VOCATION),
            new EmployeeNew(4,"赵六",8,7777.77, Status.FREE),
            new EmployeeNew(5,"田七",38,5555.55,Status.BUSY)
    );



    @Test
    public void test(){
        boolean status =  employeeList.stream()
                .allMatch(e->e.getStatus().equals(Status.BUSY));
        System.out.println(status);


        boolean status1 = employeeList.stream()
                .anyMatch(e->e.getStatus().equals(Status.BUSY));
        System.out.println(status1);

        boolean status2 = employeeList.stream()
                .noneMatch(e->e.getStatus().equals(Status.BUSY));
        System.out.println(status2);

        Optional<EmployeeNew> employeeNew = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .findFirst();
        System.out.println(employeeNew.get());

        System.out.println("===================================");

        //需求从集合中找到第一个进来的
        Optional<EmployeeNew> employeeNew1 = employeeList.parallelStream()
                .filter(e->e.getStatus().equals(Status.FREE))
                .findAny();
        System.out.println(employeeNew1.get());

    }

    @Test
    public void test2(){

        Optional<EmployeeNew> employeeNew = employeeList.stream()
                .max(Comparator.comparing(Employee::getAge));
        System.out.println(employeeNew.get());

        employeeList.stream().max(Comparator.comparing(Employee::getAge));

       employeeList.stream()
                .mapToDouble(EmployeeNew::getSalary)
               .max();
        System.out.println();




    }
}
