package cn.com.chnsys.current;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @Class: Test004
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-09-11 14:30
 */

class Parent extends Thread{
    private Semaphore wc;
    String name;
    public Parent(Semaphore semaphore,String name){
        this.wc=semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        int i = wc.availablePermits();//减一
        if (i>0){
            System.out.println(name+"天助我也，终于有茅坑了！！");
        }else {
            System.out.println(name+"怎么没有茅坑了。。。");
        }

        try {
            wc.acquire();
            System.out.println(name+"终于能上厕所了！！哭！！！");
            Thread.sleep(new Random().nextInt(1000));
            System.out.println(name+"厕所终于上完了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            wc.release();
        }
    }
}
public class Test004 {

    public static void main(String[] args) throws InterruptedException {
//        Semaphore semaphore = new Semaphore(5);  //表示最多支持多少个资源访问
//        //表示获取到资源权限
//        semaphore.acquire();
//        //获取到资源-1
//        semaphore.availablePermits();
//        //释放资源
//        semaphore.release();
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <=10 ; i++) {
            new Parent(semaphore,"第"+i+"个,").start();
        }

    }

}
