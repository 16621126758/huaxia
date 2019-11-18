package cn.com.chnsys.pojo;

/**
 * @Class: Daughter
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-02 16:49
 */
public class Daughter {

    private String name;

    private BoyFriend BoyFriend;

    public BoyFriend getBoyFriend() {
        return BoyFriend;
    }

    public void setBoyFriend(BoyFriend BoyFriend) {
        this.BoyFriend = BoyFriend;
    }

    public Daughter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Daughter{" +
                "name='" + name + '\'' +
                '}';
    }
}
