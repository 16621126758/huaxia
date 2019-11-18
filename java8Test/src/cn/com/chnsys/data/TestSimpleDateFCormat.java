package cn.com.chnsys.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
 * @Class: TestSimpleDateFCormat
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-30 11:12
 */
public class TestSimpleDateFCormat  {

    public static void main(String[] args) throws ParseException {
        // Date date = new Date();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Callable<LocalDate> task = ()->{
            return LocalDate.parse("2019-01-21",dateTimeFormatter);
        };

        ExecutorService pool = Executors.newFixedThreadPool(100);
        List<Future<LocalDate>> futures = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            futures.add(pool.submit(task));
        }
        AtomicInteger i = new AtomicInteger(1);
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
