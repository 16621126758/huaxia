package cn.com.chnsys.pojo;

/**
 * @Class: Student
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-11-14 11:22
 */
public class Student {

    private Integer id;

    private String name;

    private String sex;



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
