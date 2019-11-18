package cn.com.chnsys.pojo.taobao;

/**
 * @Class: TaobaoCity
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-22 15:41
 */
public class TaobaoCity {

    private String CityName;

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    @Override
    public String toString() {
        return "TaobaoCity{" +
                "CityName='" + CityName + '\'' +
                '}';
    }
}
