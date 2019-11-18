package cn.com.chnsys.pojo.Local;

import cn.com.chnsys.pojo.taobao.TaobaoUser;

/**
 * @Class: LocalOrder
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-22 15:43
 */
public class LocalOrder {

    private TaobaoUser localUser;

    @Override
    public String toString() {
        return "LocalOrder{" +
                "localUser=" + localUser +
                '}';
    }

    public TaobaoUser getLocalUser() {
        return localUser;
    }

    public void setLocalUser(TaobaoUser localUser) {
        this.localUser = localUser;
    }
}
