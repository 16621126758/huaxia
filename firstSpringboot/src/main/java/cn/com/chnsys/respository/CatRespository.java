package cn.com.chnsys.respository;

import cn.com.chnsys.pojo.Cat;
import org.springframework.data.repository.CrudRepository;

/**
 * @Class: CatRespository
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-11 10:14
 */
public interface CatRespository extends CrudRepository<Cat,Integer> {

}
