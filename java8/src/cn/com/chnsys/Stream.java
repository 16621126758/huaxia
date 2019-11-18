package cn.com.chnsys;

import cn.com.chnsys.POJO.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Class: Stream
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-04 09:52
 */
public class Stream {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"张1","文本1","男"));
        list.add(new Student(2,"张2","文本2","男"));
        list.add(new Student(3,"张3","文本3","男"));
        list.add(new Student(4,"张4","文本4","男"));
        list.add(new Student(5,"张5","文本5","男"));
        list.add(new Student(6,"张6","文本6","男"));
        list.add(new Student(7,"张7","文本7","男"));
        list.add(new Student(8,"张8","文本8","男"));

        String names = list.stream().filter((e)->{
           return  e.getId()>3;
        }).map(e->e.getText()).collect(Collectors.joining(","));

        System.out.println(names);

        int num = list.stream().mapToInt(Student::getId).sum();
        System.out.println(num);

        List<Student> list1 = new ArrayList<>();

        Student student = null;
        Optional<Student> students = Optional.ofNullable(student);
        students.ifPresent(e-> System.out.println("Id为"+e.getText()));


    }



}
