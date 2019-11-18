package cn.com.chnsys.threaddemo;

/**
 * @Class: NormalApi
 * @description:常用Api
 * @Author: hongzhi.zhao
 * @Date: 2019-08-15 14:56
 */
public class NormalApi extends Thread{

    //getId()  线程的Id 唯一  不会重复
    //任何一个程序肯定有一个主线程
    //sleep
    //Thread.currentThread()  获取当前线程
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getId()+"子线程，i"+i+"--name:"+getName());
        }
    }

    public static void main(String[] args) {
        System.out.println(""+Thread.currentThread().getId());//主线程的Id
        System.out.println(""+Thread.currentThread().getName());//主线程的名字
        for (int i = 0; i <2 ; i++) {
            NormalApi normalApi = new NormalApi();
            normalApi.start();
        }
    }
}
