package cn.com.chnsys.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFilter;
import java.util.Date;

/**
 * @Class: Strudent
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-10 15:12
 */
public class Strudent {

    private String name;

    private int id;

    @JSONField(format = "yyyy-MM-dd HH")
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
