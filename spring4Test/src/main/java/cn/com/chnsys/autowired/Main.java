package cn.com.chnsys.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Class: Main
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-11-18 16:00
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Persion persion = (Persion) context.getBean("persion7");
        System.out.println(persion);
    }

}
