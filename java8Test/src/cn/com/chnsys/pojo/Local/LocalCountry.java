package cn.com.chnsys.pojo.Local;

import cn.com.chnsys.pojo.taobao.TaobaoCity;

/**
 * @Class: LocalCountry
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-22 15:44
 */
public class LocalCountry {

private TaobaoCity localCity;

    @Override
    public String toString() {
        return "LocalCountry{" +
                "localCity=" + localCity +
                '}';
    }

    public TaobaoCity getLocalCity() {
        return localCity;
    }

    public void setLocalCity(TaobaoCity localCity) {
        this.localCity = localCity;
    }
}
