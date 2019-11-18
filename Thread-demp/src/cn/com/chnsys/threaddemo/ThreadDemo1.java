package cn.com.chnsys.threaddemo;

/**
 * @Class: ThreadDemo1
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-05 15:37
 */
public class ThreadDemo1 extends Thread {

    /**
    *什么进程：进程就是正在运行的应用程序，进程是线程的集合
     * 什么事线程：线程就是一条执行路径，一个独立的执行单元
     * 什么事多线程   为了提高效率
     *
     * 创建线程的方法
     * 1继承Thread
     * 2实现Runnable
     * 3.使用匿名内部类的方法
     * 4.callable
    *  5.使用线程池创建线程
    * */

    public void run(){
        for (int i = 0; i <1000 ; i++) {
            System.out.println("thread:"+i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        threadDemo1.start();
        for (int i = 0; i <1000 ; i++) {
            System.out.println("main:"+i);
        }
    }

}
