package cn.com.chnsys.ExecutorPool;

import java.time.temporal.TemporalAdjuster;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Class: ExecutorDemo
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-09-17 11:13
 */
public class ExecutorDemo {

    public static void main(String[] args) {
//        //1`.可缓存线程池    可以重复利用
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 150; i++) {
//            int temp = i;
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out
//                            .println("threadName" + Thread.currentThread().getName() + "i:" + temp);
//                }
//            });
//        }



//        //2.创建可固定长度的线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        for (int i = 0; i <10 ; i++) {
//            int temp = i;
//            executorService.execute(()-> System.out.println(Thread.currentThread().getName()+",  i:"+temp));
//        }


//        //3.可定时线程池
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
//        for (int i = 0; i <10 ; i++) {
//            int temp = i;
//            scheduledExecutorService.schedule(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("threadName"+Thread.currentThread().getName()+",  i"+temp);
//                }
//            },4,TimeUnit.SECONDS);
//        }

        //单线程线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i <10 ; i++) {
            int temp = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thredadName:"+Thread.currentThread().getName()+",  i"+temp);
                }
            });
        }
        executorService.shutdown();

    }
}
