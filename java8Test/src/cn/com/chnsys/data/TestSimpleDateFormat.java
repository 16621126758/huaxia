package cn.com.chnsys.data;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Class: TestSimpleDateFormat
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-29 16:48
 */
public class TestSimpleDateFormat {

    public static void main(String[] args) throws ParseException {
       // Date date = new Date();

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Callable<Date> task = ()->{
            return  sf.parse("2019-01-21");
        };

        ExecutorService pool = Executors.newFixedThreadPool(100);
        List<Future<Date>> futures = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            futures.add(pool.submit(task));
        }
         AtomicInteger i = new AtomicInteger(1);
        //final int i =1;
        //int [] i = {1};
        futures.stream()
                .forEach(e->{
                    try {
                        System.out.println(e.get()+":"+(i.getAndIncrement()));
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    } catch (ExecutionException e1) {
                        e1.printStackTrace();
                    }
                });


        pool.shutdown();
    }

}
