package cn.com.chnsys.ThreadTongXun;

/**
 * @Class: ThreadLocalDemo
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-09-10 09:28
 */
class  ResNumber{
    private int count =0;
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return 0;
        }
    };

    public String getNumber(){
        count = threadLocal.get()+1;
        threadLocal.set(count);
        return count+++"";
    }
}
class LocalThreadDemo extends Thread{

    private ResNumber resNumber;

    public LocalThreadDemo(ResNumber resNumber){
        this.resNumber=resNumber;
    }


    @Override
    public void run() {
        for (int i = 0; i <3 ; i++) {
            System.out.println(getName()+","+resNumber.getNumber());
        }
    }
}
public class ThreadLocalDemo {

    public static void main(String[] args) {
        ResNumber resNumber = new ResNumber();
        LocalThreadDemo localThreadDemo1 = new LocalThreadDemo(resNumber);
        LocalThreadDemo localThreadDemo2 = new LocalThreadDemo(resNumber);
        LocalThreadDemo localThreadDemo3 = new LocalThreadDemo(resNumber);
        localThreadDemo1.start();
        localThreadDemo2.start();
        localThreadDemo3.start();

    }

}
