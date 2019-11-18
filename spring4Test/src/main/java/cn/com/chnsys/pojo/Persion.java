package cn.com.chnsys.pojo;

import java.util.List;

/**
 * @Class: Persion
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-11-14 15:15
 */
public class Persion {

    private String id;

    private String name;

    private List<Cat> cat;

    public Persion(){}

    public List<Cat> getCat() {
        return cat;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cat=" + cat +
                '}';
    }

    public Persion(String id, String name, List<Cat> cat) {
        this.id = id;
        this.name = name;
        this.cat = cat;
    }

    public void setCat(List<Cat> cat) {
        this.cat = cat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
