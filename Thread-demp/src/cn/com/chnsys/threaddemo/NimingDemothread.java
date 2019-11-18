package cn.com.chnsys.threaddemo;

/**
 * @Class: NimingDemothread
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-15 14:52
 */
public class NimingDemothread {

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i <1000 ; i++) {
                System.out.println("thread:"+i);
            }
        }).start();

        for (int i = 0; i <1000 ; i++) {
            System.out.println("main:"+i);
        }
    }

}
