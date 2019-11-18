package cn.com.chnsys.POJO.pojo;

/**
 * @Class: Man
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-04 15:23
 */
public class Man {
  private Godness godness;

    public Godness getGodness() {
        return godness;
    }

    public void setGodness(Godness godness) {
        this.godness = godness;
    }

    @Override
    public String toString() {
        return "Man{" +
                "godness=" + godness +
                '}';
    }

    public Man(Godness godness) {
        this.godness = godness;
    }

    public Man(){};
}
