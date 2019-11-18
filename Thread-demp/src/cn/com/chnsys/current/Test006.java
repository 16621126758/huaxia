package cn.com.chnsys.current;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.DataFormatException;

/**
 * @Class: Test006
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-09-12 12:00
 */

class ProducerThread extends Thread{
    private BlockingQueue queue;
    private boolean flage = true;
    private AtomicInteger count = new AtomicInteger();
    public ProducerThread(BlockingQueue blockingQueue){
        this.queue=blockingQueue;
    }
    @Override
    public void run() {
        System.out.println("生产者线程启动。。。");
        try {
            while (flage){
                System.out.println("正在生产队列");
                String data = count.getAndIncrement()+"";
                boolean offer = queue.offer(data);
                if (offer){
                    System.out.println("生产者添加队列"+data+"成功");
                }else {
                    System.out.println("生产者添加队"+data+"列失败");
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者线程停止");
        }
    }
    public void stopThread(){
        this.flage=false;
    }
}

class ConsumerThread extends Thread{
    private BlockingQueue queue;
    private boolean flage = true;
    private AtomicInteger count = new AtomicInteger();
    public ConsumerThread(BlockingQueue blockingQueue){
        this.queue=blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("消费者线程启动");
        try {
        while (flage){

                String data = (String)queue.poll(2, TimeUnit.SECONDS);
                if (null!=data){
                    System.out.println("消费者获取data"+data+"成功");
                }else{
                    System.out.println("消费者获取data"+data+"失败");
                    flage=false;
                }
            } }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("停止线程。。。");
            }
        }

}



public class Test006 {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<Object> queue = new LinkedBlockingDeque<>(10);
        ProducerThread producerThread1 = new ProducerThread(queue);
        ProducerThread producerThread2 = new ProducerThread(queue);
        ConsumerThread consumerThread = new ConsumerThread(queue);
        producerThread1.start();
        producerThread2.start();
        consumerThread.start();
        Thread.sleep(10000);
        producerThread1.stopThread();
        producerThread2.stopThread();
    }
}
