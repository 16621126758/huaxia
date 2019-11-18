package cn.com.chnsys.Annotation;

import java.lang.reflect.Method;
import org.junit.Test;

/**
 * @Class: TestAnnotation
 * @description:重复注解与类型注解
 * @Author: hongzhi.zhao
 * @Date: 2019-08-01 10:32
 */
public class TestAnnotation {


    @MyAnnotation("hello")
    @MyAnnotation("WORLD")

    public void show(){

    }


    @Test
    public void test() throws NoSuchMethodException {
        Class clzz = TestAnnotation.class;
        Method show = clzz.getMethod("show");
        MyAnnotation[] annotationsByType = show.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation:annotationsByType){
            System.out.println(myAnnotation.value());
        }
    }

    public void showw(@MyAnnotation("sdf") String a){

    }

}
