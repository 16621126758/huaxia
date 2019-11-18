package cn.com.chnsys.ThreadTongXun;

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap;

/**
 * @Class: StopThread
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-09-09 16:37
 */

class StopThreadDemo extends Thread{

    private  volatile  boolean flag = true;
    @Override
    public void run() {
        System.out.println("子线程开始执行-----");
        while (flag){

        }
        System.out.println("子线程结束执行------");
    }

    public void stopThread(){
        System.out.println("调用stop方法");
        this.flag=false;
        System.out.println("已经将flag修改为："+flag);
    }
}
public class StopThread {

    public static void main(String[] args) throws InterruptedException {
        StopThreadDemo stopThreadDemo = new StopThreadDemo();
        stopThreadDemo.start();
        System.out.println("");
        for (int i = 0; i < 10; i++) {
            System.out.println("我是主线程：i"+i);
            Thread.sleep(1000);
            if (i==6){
                stopThreadDemo.stopThread();
            }
        }
    }

}
