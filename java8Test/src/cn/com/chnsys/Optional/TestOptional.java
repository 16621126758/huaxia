package cn.com.chnsys.Optional;

import cn.com.chnsys.pojo.Employee;
import cn.com.chnsys.pojo.EmployeeNew;
import cn.com.chnsys.pojo.EmployeeNew.Status;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import java.util.Optional;
import org.junit.Test;

/**
 * @Class: TestOptional
 * @description: Optional  解决空指针异常
 * @Author: hongzhi.zhao
 * @Date: 2019-08-01 15:14
 *
 * Optional.of(T t)创建一个Optional 实例
 * Optional.empty()  创建一个空的Optional实例
 * Optional.ofNullable (T t) 若t不为空，创建optional实例，否则创建空实例
 * isPresent（） 判断是否包含值
 * OrElse()  如果调用对象包含值，返回该值，否则返回T
 * orElseGet(Supplier s)如果调用对象包含值，返回该值，否则返回S获取的值
 * map(Function f) 如果有值，对其处理，并返回处理后的Optional，否则返回Optional。empty
 *flatMNap（Function mapper） 与map类似，要求返回值必须是Optioanl
 *
 * orElseThrow  如果为抛出一个异常（异常可以自定义）
 */
public class TestOptional {

    @Test
    public void test(){
      // Optional<EmployeeNew> optionalEmployeeNew = Optional.of(null);
        Optional<EmployeeNew> optionalEmployeeNew = Optional.ofNullable(null);
        System.out.println(optionalEmployeeNew.get());
        //optionalEmployeeNew.ifPresent();
    }

    @Test
    public void test2(){
//        Optional<EmployeeNew> optionalEmployeeNew = Optional.empty();
//        System.out.println(optionalEmployeeNew.get());

        Optional<EmployeeNew> optionalEmployeeNew1 = Optional.ofNullable(null);
        System.out.println(optionalEmployeeNew1.get());
    }

    @Test
    public void test4(){
        EmployeeNew employeeNew = new EmployeeNew(1,"asdf",123,123,Status.BUSY);
        if (null!=employeeNew){
            System.out.println("做一些处理");
        }else{
            System.out.println("设一个默认值继续处理");
        }



       Optional<EmployeeNew> optionalEmployeeNew = Optional.ofNullable(employeeNew);
       EmployeeNew employeeNew1 = optionalEmployeeNew.orElse(TestOptional.createNewUser());

      //  System.out.println(optionalEmployeeNew.get());



    }

    @Test
    public void test3(){
        Optional<EmployeeNew> optionalEmployee = Optional.ofNullable( new EmployeeNew(1,"asdf",123,123,Status.BUSY));
        Employee employee = optionalEmployee.orElseGet(() ->TestOptional.createNewUser());
        System.out.println(employee);

    }

    @Test
    public void test5(){
        Optional<Employee> optionalEmployee = Optional.ofNullable(new Employee(1,"asdf",123,123));
        Optional<String> s = optionalEmployee.map(Employee::getName);
        System.out.println(s.get());

        Optional<String> s1 = optionalEmployee.flatMap(e -> Optional.of(e.getName()));
        System.out.println(s1.get());

    }

    private static EmployeeNew createNewUser() {
        System.out.println("create new EmployeeNew");
        return new EmployeeNew();
    }


}
