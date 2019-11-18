package cn.com.chnsys.lambda;

import java.util.Comparator;
import org.junit.Test;

/**
 * @Class: Lizi
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-23 10:59
 */
public class Lizi {

    @Test
    public void test(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int x = 1;
        int y = 2;
        int s = comparator.compare(x,y);
        System.out.println(s);
    }

    Comparator<Integer> comparator =Integer::compare;

    @Test
    public void test2(){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        new Thread(()->{

        }).start();
    }




}
