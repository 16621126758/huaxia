package cn.com.chnsys.ThreadSafe;




/**
 * @Class: TreadDemo1
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-20 16:14
 */
public class TreadDemo1 implements  Runnable {

    private int trainCount = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while (trainCount > 0) {
            //出售火車票
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();
        }
    }

    private synchronized void sale() {
      //  synchronized (obj) {
            if (trainCount > 0) {
                System.out.println(
                        Thread.currentThread().getName() + ",出售第" + (100 - trainCount + 1) + "票");
                trainCount--;
            }
      //  }
    }

    public static void main(String[] args) {
        TreadDemo1 threadDemo = new TreadDemo1();
        Thread thread = new Thread(threadDemo, "窗 口1");
        Thread thread1 = new Thread(threadDemo, "窗口2");
        thread.start();
        thread1.start();
    }
}
