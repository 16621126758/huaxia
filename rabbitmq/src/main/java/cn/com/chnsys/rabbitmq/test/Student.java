package cn.com.chnsys.rabbitmq.test;

import java.io.Serializable;

/**
 * @Class: Student
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-14 17:18
 */
public class Student implements Serializable {

    private String name;

    private int id;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
