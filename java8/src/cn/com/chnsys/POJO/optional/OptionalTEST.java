package cn.com.chnsys.POJO.optional;

import cn.com.chnsys.POJO.Student;
import cn.com.chnsys.POJO.pojo.Godness;
import cn.com.chnsys.POJO.pojo.Man;
import cn.com.chnsys.POJO.pojo.NewMan;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.Optional;
import org.junit.Test;

/**
 * @Class: OptionalTEST
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-04 14:08
 */
public class OptionalTEST {
    /*
    *
    * Optional.of (T t) 创建一个Optional实例
    * Optional.empty() 创建一个空的Optional实例
    * Optional.ofnullable(T t) 若T不为空，返回该值，否则创建空实例
    * isPreSent：判断是否包含该值
    * orElse（T t）  如果调用对象包含值，返回值，没否则返回T
    * orElseGet(Supplier s)  :如果对象包含值返回值，否则返回S获取到的值
    * map(Function f) 如果有值对其进行处理，并返回处理后的Optional，否则返回Optional.empty
    * flatMap(Function mapper) 与map类似，要求返回值必须是Optional
    * */



    @Test
    public void test4(){
        //获取一个男人心中女神的名字
//        Man man = new Man();
        Man man = new Man(new Godness("蒼井空"));
        String name = OptionalTEST.getGodnessName(man);
        System.out.println(name);


    }



    public static String getGodnessName(Man man){
        //return man.getGodness().getName();
//        if (null!=man&&null!=man.getGodness()){
//            return man.getGodness().getName();
//        }else{
//            return "苍老师";
//        }
        Optional<Man> op = Optional.ofNullable(man);

        Optional<String> name= op.map(Man::getGodness).
                                  map(Godness::getName);

        //stem.out.println(name);
       return name.get();


    }


    @Test
    public void test3(){
        Optional<Student> op = Optional.ofNullable(new Student());
        if (op.isPresent()){
            System.out.println(op.get());
            }

        op.ifPresent(e->{
            e.setId(1);
            e.setNames("赵宏志");
        });

       Student student =  op.orElse(new Student(1,"毛白杨","sdfsdf","boy"));
//         Student student = op.orElseGet(()->{
//          return  new Student(1,"毛白杨123123123123","sdfsdf","boy");
//       });
        System.out.println(student);
    }



    @Test
    public void test2(){
        Optional<Student> op = Optional.empty();
        System.out.println(op.get());
    }

    @Test
    public void test(){
        //Optional<Student> op = Optional.of(new Student());
        Optional<Student> op = Optional.of(null);
        System.out.println(op.get());
    }

}
