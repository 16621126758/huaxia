package cn.com.chnsys.Interface;



/**
 * @Class: Java8Interface
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-29 16:17
 */
public interface Java8Interface {

    public abstract String hello();

    public default String getName(){
        return "哈哈哈";
    }

    public static void show(){
        System.out.println("接口中的静态方法");
    }

}
