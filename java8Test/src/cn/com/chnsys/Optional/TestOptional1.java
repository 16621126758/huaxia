package cn.com.chnsys.Optional;



import cn.com.chnsys.pojo.BoyFriend;
import cn.com.chnsys.pojo.Daughter;
import cn.com.chnsys.pojo.Father;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Optional;
import org.junit.Test;

/**
 * @Class: TestOptional1
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-02 16:51
 */
public class TestOptional1 {

//    @Test
//    public void test(){
//        Father father = new Father();
////        String name = father.getDaughter().getName();
////        System.out.println(name);
//
//        if (null!=father){
//            Daughter Daughter = father.getDaughter();
//            if (null!=Daughter){
//                String name1 = Daughter.getName();
//                if (null!=name1&&"".equals(name1)){
//                    System.out.println(name1+"123");
//                }
//                else{
//                    System.out.println("设置一个默认值");
//                }
//            }
//        }
//
//        Optional<Father> optionalfather = Optional.of(father);
//        String s  = optionalfather.map(Father::getDaughter)
//                .map(Daughter::getName)
//                .orElse("小芳");
//        System.out.println(s);
//
//
//    }

    @Test
    public void test3(){
        Father father = new Father();
        try {
           String s = getDaughterBoyName(father);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
         //   System.out.println(e.toString());
        }

    }
    public String getDaughterBoyName(Father father) throws Exception {
        if (null!=father){
            Daughter Daughter = father.getDaughter();
            if (null!=Daughter){
                BoyFriend boyFriend = Daughter.getBoyFriend();
                if (null!=boyFriend){
                    return boyFriend.getName();
                }else{
                    return "小明";
                }
            }else{
                return "没有男朋友";
            }
        }else{
           return "参数为空";

        }
    }

    public Optional<String> getDaughterBoyName2(Father father) throws Exception {
        Optional<String> s = Optional.ofNullable(father)
                .map(Father::getDaughter)
                .map(Daughter::getBoyFriend)
                .map(BoyFriend::getName);
        s.ifPresent(e->{
            //do Something
            return;
        });
        return s;
    }


    @Test
    public void test2(){
        Father father = new Father();

        if (null!=father){
            //do Something
        }

        Optional.ofNullable(father)
                .ifPresent(e->{
                    //do Something
                });
    }



}
