package cn.com.chnsys.pojo.taobao;

/**
 * @Class: Adderss
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-22 15:38
 */
public class TaobaoAdderss {

    private TaobaoCountry taobaoCountry;

    @Override
    public String toString() {
        return "TaobaoAdderss{" +
                "taobaoCountry=" + taobaoCountry +
                '}';
    }

    public TaobaoCountry getTaobaoCountry() {
        return taobaoCountry;
    }

    public void setTaobaoCountry(TaobaoCountry taobaoCountry) {
        this.taobaoCountry = taobaoCountry;
    }
}
