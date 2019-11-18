package cn.com.chnsys.ThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.text.StyledEditorKit.ForegroundAction;

/**
 * @Class: VolatileNoAtomic
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-09-06 10:18
 */
public class VolatileNoAtomic  extends Thread{

    //需要10个线程共享count  static修改时关键字，存放在静态区，只会存放一次，所有的线程都共存
   // private volatile static int count = 0;

   private static AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 1000 ; i++) {
           count.getAndIncrement();
        }
        System.out.println(getId()+","+count.get());
    }

    public static void main(String[] args) {
        //创建10个线程
        VolatileNoAtomic[] volatileNoAtomics = new VolatileNoAtomic[10];
        for (int i = 0; i <volatileNoAtomics.length ; i++) {
            volatileNoAtomics[i] =  new VolatileNoAtomic();
        }

        for (int i = 0; i <volatileNoAtomics.length ; i++) {
            volatileNoAtomics[i].start();
        }
    }
}
