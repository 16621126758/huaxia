package cn.com.chnsys.POJO.pojo;

/**
 * @Class: Godness
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-04 15:24
 */
public class Godness {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Godness(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Godness{" +
                "name='" + name + '\'' +
                '}';
    }
}
