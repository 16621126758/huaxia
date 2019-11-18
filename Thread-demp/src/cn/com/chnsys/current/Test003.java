package cn.com.chnsys.current;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Class: Test003
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-09-11 11:27
 */
class Writer extends Thread{
    private CyclicBarrier cyclicBarrier;
    public Writer(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier=cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始写入数据。。。");
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //并行执行成功
        System.out.println(Thread.currentThread().getName()+"写入数据成功。。");

        //需求是，上面五个代码执行完成后，最后在同一执行下面的代码
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"所有数据执行完毕。。");
    }
}
public class Test003 {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i <5 ; i++) {
            new Writer(cyclicBarrier).start();
        }
    }

}
