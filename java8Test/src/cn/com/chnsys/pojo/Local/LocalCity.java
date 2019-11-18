package cn.com.chnsys.pojo.Local;

/**
 * @Class: LocalCity
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-22 15:46
 */
public class LocalCity {
    private String CityName;

    @Override
    public String toString() {
        return "LocalCity{" +
                "CityName='" + CityName + '\'' +
                '}';
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }
}
