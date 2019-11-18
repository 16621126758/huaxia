package cn.com.chnsys.Interface;

/**
 * @Class: SubClass
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-29 16:21
 */

//下面存在两个getName
public class SubClass /*extends MyClass*/ implements Java8Interface ,MyFunction{
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        System.out.println(subClass.getName());
        Java8Interface.show();

    }

    @Override
    public String hello() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }


}
