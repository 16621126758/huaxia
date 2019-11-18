package cn.com.chnsys.autowired;

/**
 * @Class: Car
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-11-14 17:33
 */
public class Car {

    private String brand;

    private double price;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
