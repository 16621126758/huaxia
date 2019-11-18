package cn.com.chnsys.pojo.Local;

import cn.com.chnsys.pojo.taobao.TaobaoAdderss;
import cn.com.chnsys.pojo.taobao.TaobaoCountry;

/**
 * @Class: LocalAddress
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-22 15:44
 */
public class LocalAddress {

    private TaobaoCountry localCountry;

    public TaobaoCountry getLocalCountry(TaobaoAdderss taobaoAdderss) {
        return localCountry;
    }

    public void setLocalCountry(TaobaoCountry localCountry) {
        this.localCountry = localCountry;
    }

    @Override
    public String toString() {
        return "LocalAddress{" +
                "localCountry=" + localCountry +
                '}';
    }
}
