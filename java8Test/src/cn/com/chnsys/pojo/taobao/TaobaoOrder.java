package cn.com.chnsys.pojo.taobao;

/**
 * @Class: TaobaoOrder
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-22 15:37
 */
public class TaobaoOrder {

    private TaobaoUser user;

    public TaobaoUser getUser() {
        return user;
    }

    public void setUser(TaobaoUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TaobaoOrder{" +
                "user=" + user +
                '}';
    }
}
