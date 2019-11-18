package cn.com.chnsys.threaddemo;

/**
 * @Class: RunnableDemo
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-05 15:51
 */
public class RunnableDemo implements Runnable {


    @Override
    /**
     * sdaf
     */
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println("thread:"+i);
        }
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableDemo());
        thread.start();

        for (int i = 0; i <1000 ; i++) {
            System.out.println("amin:"+i);
        }
    }
}
