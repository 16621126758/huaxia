package cn.com.chnsys.Service;

import cn.com.chnsys.pojo.Cat;
import cn.com.chnsys.respository.Cat2Respository;
import cn.com.chnsys.respository.CatRespository;
import java.util.List;
import javax.transaction.Transactional;
import net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Class: CatService
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-11 10:16
 */

@Service
public class CatService {

    @Autowired
    private CatRespository catRespository;
    @Autowired
    private Cat2Respository cat2Respository;

    /*
    * 下面的方法需要绑定事务
    * */

    @Transactional
    public void  save(Cat cat){
        catRespository.save(cat);
    }
    @Transactional
    public void delete(int id){
        catRespository.deleteById(id);
    }

    public Iterable<Cat> getAll(){
        return catRespository.findAll();
    }

    public Cat findByCatName(String catName){
        return cat2Respository.findByCatName(catName);
    }
    public Cat findByCatName2(String catName){
        return cat2Respository.findByCatName(catName);
    }
}
