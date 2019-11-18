package cn.com.chnsys.threaddemo;

/**
 * @Class: JoinDemo
 * @description:join方法
 * @Author: hongzhi.zhao
 * @Date: 2019-08-20 09:38
 *
 * join正在A线程，另一个线程调用B这个Join方法，作用：A等待B线程完成后，在继续进行，优先级
 */
public class JoinDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i <60 ; i++) {
                System.out.println("子线程：i:"+i);
            }
        });
        thread.start();
        //需要让子线程先执行完毕的话怎么做
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <30 ; i++) {
            System.out.println("主线程：i："+i);
        }
    }
}
