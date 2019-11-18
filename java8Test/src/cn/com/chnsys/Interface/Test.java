package cn.com.chnsys.Interface;

/**
 * @Class: Test
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-22 11:39
 */
public class Test implements Java8Interface {

    public static void main(String[] args) {
        Test test = new Test();
        test.getName();
        Java8Interface.show();
    }


    @Override
    public String hello() {
        return null;
    }
}
