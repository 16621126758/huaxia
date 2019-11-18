package com.chnsys.cn.microservicesimpleconsumermovie.pojo;

import java.math.BigDecimal;

/**
 * @Class: User
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-21 16:53
 */
public class User {

    private Long id;
    private String userName;
    private String name;
    private Short age;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
