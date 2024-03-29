package cm.chnsys.com.activemqdemo;

import java.io.Serializable;

/**
 * @Class: qwe
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-24 15:37
 */
public class Qwe implements Serializable {

    private int id;

    private String name;

    private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Qwe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
