package cn.com.chnsys.current;

import java.util.concurrent.CountDownLatch;

/**
 * @Class: Test002
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-09-11 10:20
 */
public class Test002 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread = new Thread(() -> {
            System.out.println("我是子线程开始执行任务。。。。"+Thread.currentThread().getName());

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          //  countDownLatch.countDown();  //每次-1
            System.out.println(countDownLatch.getCount());
            System.out.println("我是子线程开始执行任务。。。。"+Thread.currentThread().getName());
            countDownLatch.countDown();  //每次-1

        });
        thread.start();

        Thread thread1 = new Thread(() -> {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("我是子线程开始执行任务。。。。"+Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //countDownLatch.countDown();    //每次-1
            System.out.println("我只子线程开始执行任务。。。。"+Thread.currentThread().getName());
            countDownLatch.countDown();  //每次-1

        });
        thread1.start();
      //  thread1.join();
        countDownLatch.await();  //当countDownLatch为0的时候才开始执行  如果不为0 不会往后面走
        System.out.println("我是主线程。。。");
        for (int i = 0; i <10  ; i++) {
            System.out.println("main"+i);
        }
    }
}
