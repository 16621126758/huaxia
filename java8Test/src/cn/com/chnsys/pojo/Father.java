package cn.com.chnsys.pojo;

/**
 * @Class: Father
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-02 16:48
 */
public class Father {

    private String name;

    private Daughter Daughter;

    public Father(String name, Daughter Daughter) {
        this.name = name;
        this.Daughter = Daughter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Daughter getDaughter() {
        return Daughter;
    }

    public void setDaughter(Daughter Daughter) {
        this.Daughter = Daughter;
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", Daughter=" + Daughter +
                '}';
    }

    public Father() {
    }
}
