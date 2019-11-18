package cn.com.chnsys.pojo.taobao;

/**
 * @Class: TaobaoCountry
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-22 15:39
 */
public class TaobaoCountry {
    private TaobaoCity taobaoCity;

    @Override
    public String toString() {
        return "TaobaoCountry{" +
                "taobaoCity=" + taobaoCity +
                '}';
    }

    public TaobaoCity getTaobaoCity() {
        return taobaoCity;
    }

    public void setTaobaoCity(TaobaoCity taobaoCity) {
        this.taobaoCity = taobaoCity;
    }
}
