package cn.com.chnsys.ThreadTongXun;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.ir.WhileNode;

/**
 * @Class: OutInputThread
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-09-06 11:35
 */
class Res{
    private String name;
    private String sex;
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

class Out extends Thread{
    Res res;
    public Out(Res res){
        this.res=res;
    }

    @Override
    public void run() {
        //写的操作
        int count = 0;
        while(true){
            synchronized (res) {
                if (res.flag){
                    try {
                        res.wait();
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
                res.notify();
            }
        }
    }
}

class Input extends Thread{
    Res res;

    public Input(Res res){
        this.res=res;
    }
    @Override
    public void run() {
        while (true){
            synchronized (res) {
                if (!res.flag){
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.getName()+","+res.getSex());
                res.flag=false;
                res.notify();
            }
        }
    }
}

public class OutInputThread {

    public static void main(String[] args) {
        Res res = new Res();
        Out out = new Out(res);
        Input input = new Input(res);
        out.start();
        input.start();

    }

}
