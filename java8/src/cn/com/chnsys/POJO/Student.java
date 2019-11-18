package cn.com.chnsys.POJO;

/**
 * @Class: Student
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-04 09:53
 */
public class Student {

    private int id;

    private String names;

    private String text;

    private String sex;

    public Student(){};

    public Student(int id,String names,String text,String sex){
        this.id=id;
        this.names=names;
        this.text=text;
        this.sex=sex;
        System.out.println("创建对象");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", text='" + text + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
