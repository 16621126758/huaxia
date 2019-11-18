package cn.com.chnsys.current;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Class: Test005
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-09-11 17:16
 */
public class Test005 {



    public static void main(String[] args) throws InterruptedException {
        //无界  无线进行存储的
//        ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
//        concurrentLinkedDeque.offer("张三");
//        concurrentLinkedDeque.offer("李四");
//        System.out.println(concurrentLinkedDeque.pollLast());
//        System.out.println(concurrentLinkedDeque.size());

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        boolean a = arrayBlockingQueue.add("张三");
        arrayBlockingQueue.offer("李四");
        arrayBlockingQueue.offer("王五");
        boolean zhaoliu = arrayBlockingQueue.offer("zhaoliu");

        System.out.println(zhaoliu);
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.peek());
        System.out.println(arrayBlockingQueue.peek());
        System.out.println(arrayBlockingQueue.peek());
        System.out.println(arrayBlockingQueue.peek());

    }
}
