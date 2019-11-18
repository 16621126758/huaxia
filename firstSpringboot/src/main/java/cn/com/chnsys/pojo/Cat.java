package cn.com.chnsys.pojo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Class: Cat
 * @description:创建一个需要持久化的类，会自动在mysql中生成相应的表
 * 使用@Entity进行实体类的持久化操作，当jpa检测到实体类当中有@Entity的时候
 * 会在数据库中生成对应的表结构信息
 * 2.如何指定主键以及主键的生成策略？
 * 使用@Id生成主键，@GeneratedValue 设置生成主键的策略
 * @Author: hongzhi.zhao
 * @Date: 2019-06-11 09:53
 */

@Entity
public class Cat {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String catName;

    private String catAge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatAge() {
        return catAge;
    }

    public void setCatAge(String catAge) {
        this.catAge = catAge;
    }
}
