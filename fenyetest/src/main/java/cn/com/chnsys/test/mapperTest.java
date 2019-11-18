package cn.com.chnsys.test;

import cn.com.chnsys.dao.DepartmentMapper;
import cn.com.chnsys.dao.EmployeeMapper;
import cn.com.chnsys.pojo.Department;
import cn.com.chnsys.pojo.Employee;
import java.util.UUID;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Class: mapperTest
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-10 13:54
 *
 * 推荐spring的项目可以使用spring做项目测试，可以自动注入我们需要的组件
 * @ContextConfiguration指定spring配置文件的位置
 * 直接autowired使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-mybatis.xml", "classpath:applicationContext.xml"})
public class mapperTest {
    /*
    *测试departmentMapper
    * */
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;
    @Test public void testCRUD(){
//        //1创建springioc容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        //从容器中获取mapper
//        DepartmentMapper departmentMapper = applicationContext.getBean(DepartmentMapper.class);
        System.out.println(departmentMapper);

//        //1.插入几个部门
//        Department department = new Department();
//        department.setDeptName("开发部");
//        departmentMapper.insertSelective(department);
//        departmentMapper.insertSelective(new Department(null,"测试"));

        //生成员工数据  上面的不是批量插入，需要很久
//        for (){
//            employeeMapper.insertSelective(new Employee(null,"jerry","M","jeery@qq.com",1));
//
//        }
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0;i<1000;i++) {
            String name = UUID.randomUUID().toString().substring(0,5)+i;
           employeeMapper.insertSelective(new Employee(null,name,"M",name+"@qq.com",1));
        }


    }

}
