package cn.com.chnsys.fileupload.controller;


import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.SwingUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Class: SmartUploadController
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-05 10:16
 */
@Controller
public class SmartUploadController{



    @Autowired
    private cn.com.chnsys.fileupload.config.ServletConfig servletConfig;


    @RequestMapping("piliang")
    public String piliang(){
        return "smartupload";
    }
    @RequestMapping(value = "smartupload",method = RequestMethod.POST)
    public String upload(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, SmartUploadException, IOException {

        //这是文件上传的路径
        String filePath = request.getServletContext().getRealPath("/")+"images";
        System.out.println(filePath);
        File file = new File(filePath);
        if (!file.exists()){
            file.mkdir();
        }

        System.out.println(file.exists());
        SmartUpload su = new SmartUpload();
        //初始化对象

        try {
            su.initialize(servletConfig.getServletConfig(),request,response);
            su.getFiles().getCount();
            System.out.println("----------"+su.getFiles().getCount());
            //设置上传文件的大小
            su.setMaxFileSize(1024*1024);

            //设置上传所有文件的大小
            su.setTotalMaxFileSize(1024*1024*100);
            //设置允许上传文件的类型
            su.setAllowedFilesList("txt,jpg,gif");

            //设置不允许上传文件的类型

            su.setDeniedFilesList("rar,jsp,js");

            System.out.println("开始上传");


            su.upload();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        int i = su.getFiles().getCount();
        System.out.println("文件数量为"+i);

        int count = 0;
        System.out.println("kaishibaocun");
        count = su.save(filePath);

        System.out.println("上传成功"+count+"个文件！");

        return "success";
    }


}
