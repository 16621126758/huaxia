package cn.com.chnsys.lambda;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Class: GodenessTest
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-25 11:27
 */
public class GodenessTest {

    public  String getName(Godeness godeness){

        return godeness.getName();
    }



    public  String test(){
       //  int num = 1;
        AtomicInteger atomicInteger = new AtomicInteger(1);
        //     int num = 0; //jdk 1.8以前，局部内部类中应用了同级别的局部变量时，必须加final
        int [] num = {1};
//        return getName(()->  {return "张三"+num[0]++;});
        return getName(()->"張三"+num[0]++);
    }

    public static void main(String[] args) {
        System.out.println(new GodenessTest().test());

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        new Thread(()->{

        }).start();



//        Godeness godeness = ()-> "zhagnsan";
//        String name = godeness.getName();
//        System.out.println(name);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();
//
//
//        new Thread(()->{
//
//        }).start();
    }
}
