package cn.com.chnsys.MethodRef;

import cn.com.chnsys.pojo.Employee;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.beans.Transient;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;

/**
 * @Class: MethodRed
 * @description: 方法引用
 * @Author: hongzhi.zhao
 * @Date: 2019-07-25 17:18
 *
 *
 * 方法引用：若Lambda中有方法已经实现了，我们可以使用“方法引用”
 *          （可以理解方法引用是Lambda 表达式的另外一种表现形式）
 * 主要有三种语法格式：
 * 对象：：实例方法名字
 * 类：：静态方法名
 * 类：：实例方法名字
 *
 *
 * 构造器引用：
 * 格式
 *    ClassName::new
 *
 *    构造器中的参数列表要与函数式接口中的参数列表保持一致
 */
public class MethodRef {

    //Lambda体调用方法的参数列表与返回类型，要与函数式接口中抽象方法的参数列表和返回值一致。
    @Test
    public  void test(){

        //类：：实例方法名(特殊，有条件)  Lambdati体中 参数类表，第一个参数是实例方法的调用者，第二个参数是实例方法的参数。
        BiPredicate<String,String> biPredicate = (x,y)->x.equals(y);
        BiPredicate<String,String> biPredicate1 = String::equals;

        //对象：：实例方法名
        Employee employee = new Employee();
        Supplier<String> supplier = ()->  employee.getName();
        Supplier<String> supplier1 = new Employee()::getName;
      //  Consumer<String> consumer =(e)-> System.out.println(e);
        Consumer<String> consumer = System.out::println;
        consumer.accept("nihao");




        //类：：静态方法名
        Comparator<Integer> com = (x,y)->Integer.compare(x,y);
        Comparator<Integer> com1 = Integer::compare;
        System.out.println(com1.compare(1,1));

    }

    //构造器的引用
    @Test
    public void test2(){
        Supplier<Employee> supplier = ()-> new Employee();


        Supplier<Employee> supplier1 = Employee::new;
        supplier1.get();

        Function<String,Employee> fun = (e)->new Employee(e);
        Function<Integer,Employee> function = Employee::new;
        Employee employee = function.apply(1);
        System.out.println(employee);


        //数组引用
        Function<Integer,String[]> function1 = String[]::new;
        String [] arr = function1.apply(5);
        System.out.println(arr.length);
        Function<Employee,String> function2 = Employee::getName;

        }




}
