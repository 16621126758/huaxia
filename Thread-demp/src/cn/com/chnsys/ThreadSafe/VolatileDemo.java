package cn.com.chnsys.ThreadSafe;

/**
 * @Class: VolatileDemo
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-09-06 09:41
 */
public class VolatileDemo extends Thread{
    private volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("子线程开始执行");
        while (flag){

        }
        System.out.println("子线程执行结束");
    }

    public void stopThread(boolean flag){
        this.flag=false;
    }


    public static void main(String[] args) throws InterruptedException {
        VolatileDemo volatileDemo = new VolatileDemo();
        volatileDemo.start();
        Thread.sleep(3000);
        volatileDemo.stopThread(false);
        System.out.println("flag已经修改为flase");
        Thread.sleep(1000);
        System.out.println(volatileDemo.flag);

    }
}
