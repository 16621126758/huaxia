package cn.com.chnsys.pojo.Local;

import cn.com.chnsys.pojo.taobao.TaobaoAdderss;
import cn.com.chnsys.pojo.taobao.TaobaoUser;

/**
 * @Class: LocalUser
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-22 15:43
 */
public class LocalUser {
  private TaobaoAdderss localAddress;

    @Override
    public String toString() {
        return "LocalUser{" +
                "localAddress=" + localAddress +
                '}';
    }

    public TaobaoAdderss getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(TaobaoAdderss localAddress) {
        this.localAddress = localAddress;
    }
}
