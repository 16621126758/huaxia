package cn.com.chnsys.lambda;

/**
 * @Class: TestLambda
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-24 11:15
 */


import java.util.Comparator;
import java.util.function.Consumer;
import org.junit.Test;

/**
 * 一：Lambda表达式的基础语法 ：java8引入了一个新的操作符"->"(箭头操作符)
 *                           箭头将Lambda表达式拆成两部分：
 * 左侧：表达式的参数列表   函数式接口中抽象方法的参数列表
 * 右侧：表达式所需执行的功能  抽象方法的实现
 *
 * 语法格式一：无参数无返回值
 *          ()->System.out.print("Hello world")
 * 语法格式二：有参数无返回值
 *          (e)->System.out.print("Hello world")
 * 语法格式三：若只有一个参数，小括号可以不写
 *          e->System.out.print("hello)
 * 语法格式四：有两个以上的参数，有返回值，并且Lambda体中有多条语句
 *           ( x, z)->{
 *             return Integer.compare(x,z);
 *              };
 * 语法格式五：lambda体中只有一条语句return和大括号可以不写
 *
 * 语法格式六：lambda表达式中参数的数据类型可以不写
 *
 *  * 函数式接口：接口中只有一个抽象方法的接口，可以使用@FunctionInterface
 *
 */
public class TestLambda {

    @Test
    public void test1(){


        new Thread(()->{
            System.out.println("hello");
        }).start();
    }

    @Test
    public void test2(){
        Consumer<String> con = x-> System.out.println(x);
        con.accept("qweqweqwewqeqw");
//        new Consumer<String>() {
//            @Override
//            public void accept(String o) {
//                System.out.println(o);
//            }
//        }.accept("asdf");
    }
    @Test
    public void test3(){
        Comparator<Integer> com = ( x, z)->{
            return Integer.compare(x,z);
        };
        System.out.println(com.compare(1,8));;
    }



}
