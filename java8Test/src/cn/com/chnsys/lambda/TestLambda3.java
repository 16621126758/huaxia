package cn.com.chnsys.lambda;

import cn.com.chnsys.pojo.Employee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.junit.Test;


/**
 * @Class: TestLambda3
 * @description:  四大核心函数式接口
 * @Author: hongzhi.zhao
 * @Date: 2019-07-25 15:51
 */
public class TestLambda3 {

    //consumer<T> 消费型接口
    @Test
    public void test(){
        shopping(10000,(e)-> System.out.println("本息消费了："+e+"元"));

        Consumer<Double> con = (e)-> System.out.println("sdf"+e);
        con.accept(123.0);


        Consumer<String> c = (e)-> System.out.println(e+"jack");
        Consumer<String> c1 = (e)-> System.out.println("End"+e);
        c.andThen(c1).accept("hello");
    }

    public void shopping(double money,Consumer<Double> consumer){
        consumer.accept(money);
    }

    //Supplier<T>供给型接口  返回对象
    @Test
    public void test1(){
        //生成100以内的10个随机数
        List<Integer> list = getNumList(10,()->  (int)(Math.random()*100));
        list.stream()
                .forEach(System.out::println);
       // Supplier<Employee> supplier = Employee::new;
        Supplier<Employee> supplier = ()->new Employee();
        Employee employee = supplier.get();
        employee.setAge(11);
        System.out.println(employee);
    }
    public List<Integer> getNumList(int num,Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<=num;i++){
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

    //Function<T,R> 函数型接口
    @Test
    public void test3(){
       String str =  strHandler("我叫张三sadf",(e)->{
                       System.out.println(e.length());
               return e.substring(1,4).trim();
       });
        System.out.println(str);
    }

    public String strHandler(String m,Function<String,String> function){
        return function.apply(m);
    }

    @Test
    public void test4(){
        List<String> list = Arrays.asList("hello","str","asdf","sdf");
        List<String> stringList = filterStr(list,s -> s.length()>2 );
        stringList.stream().
                forEach(System.out::println);
        List<String> collect = list.stream()
                .filter(e -> e.length() > 2)
                .collect(Collectors.toList());
        collect.stream()
                .forEach(System.out::println);
    }
    //Predicate 断言接口
    public List<String> filterStr(List<String> list,Predicate<String> predicate){
        List<String> list1 = new ArrayList<>();
        for (String str:list){
            if (predicate.test(str)){
                list1.add(str);
            }
        }
        return list1;
    }

    @Test
    public void test6(){
       String s =  qwe("黃曉明","baby",(x,y)->{
            return x+"和"+y+"是夫妻";
        });
        System.out.println(s);
    }

    public String qwe(String a,String b, BiFunction<String,String,String> biFunction){
        return biFunction.apply(a,b);
    }


}
