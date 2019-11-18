package cn.com.chnsys.respository;


import cn.com.chnsys.pojo.Cat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * @Class: Cat2Respository
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-11 11:21
 */
public interface Cat2Respository extends Repository<Cat,Integer> {

    /*
    * 查询方法发已 get|find|read
    * 涉及查询方法时，条件的属性用条件关键字连接，要注意的是，条件属性已首字母大写
    * */

    //根据catName进行查询

    public Cat findByCatName(String catName);

    //如何编写jpql语句y
    //Hibernate  HQL语句
    //jqql和hql语句类似

    @Query("from Cat where catName =:catName")
    public Cat findByMCatName2(String catName);


}
