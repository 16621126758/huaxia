package cn.com.chnsys.threaddemo;

/**
 * @Class: JoinTest
 * @description:现在有T1,T2,T3三个子线程，怎样保证T2在T1执行完后执行T2，T3在T2完后执行
 * @Author: hongzhi.zhao
 * @Date: 2019-08-20 10:15
 */
public class JoinTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                System.out.println("T1:i:"+i);
            }
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i <100 ; i++) {
                System.out.println("T2:i:"+i);
            }
        });

        Thread t3 = new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i <100 ; i++) {
                System.out.println("T3:i:"+i);
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
