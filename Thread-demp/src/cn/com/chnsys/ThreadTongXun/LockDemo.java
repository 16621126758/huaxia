package cn.com.chnsys.ThreadTongXun;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Class: OutInputThread
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-09-06 11:35
 */
class ResNew{
    private String name;
    private String sex;
    public Lock lock = new ReentrantLock();
    //true 生产者线程等待 false 生产者线程进行生产
    public volatile boolean flag = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

class OutNew extends Thread{
    ResNew res;
    Condition condition;
    public OutNew(ResNew res,Condition condition){
        this.res=res;
        this.condition=condition;
    }

    @Override
    public void run() {
        //写的操作
        int count = 0;
        while(true){
            try {
                res.lock.lock();
              //  Condition condition = res.lock.newCondition();
                if (res.flag){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (count==0){
                    res.setName("小红");
                    res.setSex("女");
                }else {
                    res.setName("小明");
                    res.setSex("男");
                }
                //计算基数或者偶数公式
                count=(count+1)%2;
                res.flag=true;
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                res.lock.unlock();
            }

        }
    }
}

class InputNew extends Thread{
    ResNew res;
    Condition condition;

    public InputNew(ResNew res,Condition condition){
        this.res=res;
        this.condition=condition;
    }
    @Override
    public void run() {
        while (true){

            try {
                res.lock.lock();
                //Condition condition = res.lock.newCondition();
                if (!res.flag){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(res.getName()+","+res.getSex());
                res.flag=false;
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                res.lock.unlock();
            }
        }
    }
}

public class LockDemo {

    public static void main(String[] args) throws InterruptedException {
        ResNew res = new ResNew();
        Condition condition = res.lock.newCondition();
        OutNew out = new OutNew(res,condition);
        InputNew input = new InputNew(res,condition);
        out.start();
       // Thread.sleep(100);
        input.start();



    }
}
