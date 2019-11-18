package cn.com.chnsys.pojo;

import java.util.Map;

/**
 * @Class: Persion2
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-11-14 16:59
 */
public class Persion2 {
    private String id;

    private String name;

    private Map<String,Cat> cars;



    @Override
    public String toString() {
        return "Persion2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cars=" + cars +
                '}';
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

    public Map<String, Cat> getCars() {
        return cars;
    }

    public void setCars(Map<String, Cat> cars) {
        this.cars = cars;
    }
}
