package cn.com.chnsys;

import cn.com.chnsys.pojo.Cat;
import cn.com.chnsys.pojo.Persion;
import cn.com.chnsys.pojo.Persion2;
import cn.com.chnsys.pojo.Student;
import java.net.CacheRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class IOCDemo
{
    public static void main( String[] args )
    {
        //classPathApplicationContext是applicationContext接口的实现类，该实现类从类路径下来加载配置文件

        System.out.println( "Hello World!" );
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        //利用Id定位到IOC容器中的bean
        Student s = (Student)ctx.getBean("student");
        System.out.println(s);

        //利用类型定位到IOC容器中的bean,但是要求IOC容器中只能有一个该类型的bean
//        Student s1 = (Student)ctx.getBean(Student.class);
//        s1.setName("zhaohongzhi");
       // System.out.println(s1);
        Cat cat = (Cat)ctx.getBean("car");
        System.out.println(cat);
         cat = (Cat)ctx.getBean("car2");
        System.out.println(cat);
        Persion2 persion = (Persion2) ctx.getBean("persion2");
        System.out.println(persion);


    }
}
