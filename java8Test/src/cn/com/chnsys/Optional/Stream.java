package cn.com.chnsys.Optional;

import cn.com.chnsys.pojo.Employee;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * @Class: Stream
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-01 16:26
 */
public class Stream {



    List<Employee> employeeList = Arrays.asList(
            new Employee(1,"张三",18,9999.99),
            new Employee(2,"李四",59,6666.66),
            new Employee(3,"王五",28,3333.33),
            new Employee(4,"赵六",8,7777.77),
            new Employee(5,"田七",38,5555.55)
    );

  @Test
  public void test(){

       final String [] cn = {""};
    employeeList.stream().
            map(Employee::getName)
            .forEach(e->{
                cn[0] = cn[0]+e+",";
            });
    String cnn = cn[0].substring(0,cn[0].length()-1);
      System.out.println("the final is :"+cnn);
  }

}
