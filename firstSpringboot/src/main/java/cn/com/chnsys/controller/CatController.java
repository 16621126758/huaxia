package cn.com.chnsys.controller;

import cn.com.chnsys.Service.CatService;
import cn.com.chnsys.pojo.Cat;
import java.util.List;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Class: CatController
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-11 10:23
 */
@Controller
@RequestMapping("/cat")
public class CatController {
    @Autowired
    private CatService catService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        Cat cat = new Cat();
        cat.setCatAge("13");
        cat.setCatName("你好");
        catService.save(cat);
        return "save ok";
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(@RequestParam(value = "id" ) int id){
        System.out.println(id);
        catService.delete(id);
        return "delete ok";

    }

    @RequestMapping("/getAll")
    @ResponseBody
    public Iterable<Cat> getAll(){
        return catService.getAll();
    }

    @RequestMapping("findByCatName")
    @ResponseBody
    public Cat findByCatName(String catName){
        System.out.println(catName);
        return catService.findByCatName(catName);
    }

    @RequestMapping("findByCatName2")
    @ResponseBody
    public Cat findByCatName2(String catName){
        System.out.println(catName);
        return catService.findByCatName2(catName);
    }


}
