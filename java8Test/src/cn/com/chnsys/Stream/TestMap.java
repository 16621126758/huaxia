package cn.com.chnsys.Stream;

import cn.com.chnsys.pojo.Employee;
import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.lang.model.element.VariableElement;
import org.junit.Test;

/**
 * @Class: TestMap
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-26 16:12
 *
 * 映射
 *
 * map : 接受Lambda，将元素转换成其他形式或提取信息，接受一个函数作为参数，该函数会被应用到每个元素上，将其映射成一个新的流
 *
 * FlatMap：接收一个函数作为参数，将该流中每个值都替换层另一个流，然后吧所有流连成一个流
 */
public class TestMap {

    @Test
    public void test(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");


        list.stream()
                .map(e->e.toUpperCase())
                .forEach(System.out::print);

        List<Employee> employeeList = Arrays.asList(
                new Employee(1,"张三",18,9999.99),
                new Employee(2,"李四",59,6666.66),
                new Employee(3,"王五",28,3333.33),
                new Employee(4,"赵六",8,7777.77),
                new Employee(5,"田七",38,5555.55)
        );

        employeeList.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        Stream<String> stringStream = employeeList.stream()
                .flatMap(e -> Stream.of(e.getName()));
        stringStream.forEach(e-> System.out.println(e+"123"));


        //flatform
//        employeeList.stream()
//                .flatMap(e->Stream.of(e.getSalary()))
//                .forEach(System.out::println);



        //需求将list中的字符串拆分再放到集合中
        Stream<Stream<Character>> streamStream = list.stream()
                .map(TestMap::filterCharacter);

        //streamStream.forEach(System.out::println);
        streamStream.forEach(e->e.forEach(System.out::println));

        System.out.println("-------------------------------");

        Stream<Character> stream = list.stream()
                .flatMap(TestMap::filterCharacter);
        stream.forEach(System.out::print);
        System.out.println();
        System.out.println("--------------------------");
        List list1 = new ArrayList();
        list1.add(11);
        list1.add(22);
       // list1.add(list);
        list1.addAll(list);
        list1.forEach(System.out::println);





    }



    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character character:str.toCharArray()){
            list.add(character);
        }
        return list.stream();
    }

}
