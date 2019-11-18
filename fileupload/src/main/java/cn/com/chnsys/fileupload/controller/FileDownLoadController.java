package cn.com.chnsys.fileupload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class: FileDownLoadController
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-03 17:02
 */
@RestController
public class FileDownLoadController {


    //如果要下载，首先要获取要下载的路径,然后拼接文件名字，判断是否有这个文件，
    //然后设置头，设置contentType，然后headers。add  （文件描述）就是下载显示的文件名字
    //然后设置状态
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download( @RequestParam("filename") String text,HttpServletRequest request)
            throws IOException {
        request.setCharacterEncoding("utf-8");
        String path = request.getServletContext().getRealPath("/")+"images/";
        String downloadName = text;
        File file = new File(path,downloadName);


        //application/octet-stream二进制流数据（最常见的文件下载）。
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName1 =new String(text.getBytes("UTF-8"),"iso-8859-1");//解决文件名乱码
        headers.add("Content-Disposition", "attachment;filename="+fileName1);
        //通知浏览器以attachment（下载方式）打开图片

      //  headers.setContentDispositionFormData("attachment",fileName1);
        HttpStatus statusCode = HttpStatus.OK;//设置响应吗
        InputStream inputStream = new FileInputStream(file);
        byte[] body=null;
        body=new byte[inputStream.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
        inputStream.read(body);//读入到输入流里面
        ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, statusCode);
        inputStream.close();
       return response;
        }
}
