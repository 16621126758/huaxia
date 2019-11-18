package cn.com.chnsys.autowired;

/**
 * @Class: Address
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-11-14 17:31
 */
public class Address {

    private String city;

    private String street;

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
