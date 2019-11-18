package cn.com.chnsys.POJO.pojo;

import java.util.Optional;

/**
 * @Class: NewMan
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-04 16:04
 */
public class NewMan {

    private Optional<Godness> godness = Optional.empty();

    public NewMan(Optional<Godness> godness) {
        this.godness = godness;
    }

    public NewMan() {
    }

    public Optional<Godness> getGodness() {
        return godness;
    }

    public void setGodness(Optional<Godness> godness) {
        this.godness = godness;
    }

    @Override
    public String toString() {
        return "NewMan{" +
                "godness=" + godness +
                '}';
    }
}
