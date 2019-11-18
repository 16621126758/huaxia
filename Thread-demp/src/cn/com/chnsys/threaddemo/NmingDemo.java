package cn.com.chnsys.threaddemo;

/**
 * @Class: NmingDemo
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-13 17:50
 */

abstract  class parent{
    public abstract String getName();
}
public class NmingDemo {

    public static void main(String[] args) {
        parent p = new parent() {
            @Override
            public String getName() {
                System.out.println("haha");
                return "hello";
            }
        };
        p.getName();
    }
}
