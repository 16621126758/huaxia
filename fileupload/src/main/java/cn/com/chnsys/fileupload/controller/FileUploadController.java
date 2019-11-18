package cn.com.chnsys.fileupload.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @Class: FileUploadController
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-05-30 15:39
 */
@Controller
public class FileUploadController {

    private org.slf4j.Logger log = LoggerFactory.getLogger(FileUploadController.class);
    @RequestMapping("/hello")
    public String hello(){
        return "02";
    }

    @RequestMapping(value = "/upload" ,method =RequestMethod.POST )
    @ResponseBody
   // public String text(HttpServletRequest request, HttpServletResponse response )
    public String text(@RequestParam("myfile") MultipartFile file,HttpServletRequest request)
            throws IOException {
//        //从request中获取流的信息
//        InputStream fileSource = request.getInputStream();
//        String tempFilename = "G:/tempFile";
//        //tempfile指向临时文件
//        File tempFile= new File(tempFilename);
//
//        FileOutputStream outputStream = new FileOutputStream(tempFile);
//        int temp;
//        //一个一个字节的读取并写入
//        byte b [] = new byte[1024];
//        while((temp=fileSource.read(b))!=(-1))
//        {
//            outputStream.write(temp);
//        }
//        //关闭输入流输出流
//        outputStream.close();
//        fileSource.close();
//        System.out.println(":2w3r4werew");

        //用来检测程序运行时间
        System.out.println("fileName："+file.getOriginalFilename());

        try {
            //获取输出流
            String realPath1 = request.getServletContext().getRealPath("/")+"images"+"\\"+file.getOriginalFilename();
            System.out.println(realPath1);
            System.out.println(request.getServletContext().getRealPath("/"));

           // File file1 = new File("G:/zhz");
            File file1 = new File(realPath1);
            System.out.println("判断文件是否粗"+file1.exists());
            //OutputStream os=new FileOutputStream("E:/"+new Date().getTime()+file.getOriginalFilename());
            OutputStream os=new FileOutputStream(file1);
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
           // byte b [] = new byte[1024];
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();

//            //读取文件内容
//            RandomAccessFile randomAccessFile = new RandomAccessFile(file1,"r");
//            randomAccessFile.readLine();
//            randomAccessFile.readLine();
//            String str = randomAccessFile.readLine();
//            System.out.println("str----"+str);
//            int begin = str.lastIndexOf(">/")+2;
//            int end = str.lastIndexOf("</");
//            String text = str.substring(begin,end);
//            System.out.println("text-------"+text);
//
//            //重新定位文件指针到文件头
//
//            randomAccessFile.seek(0);
//            long startPosition = 0;
//            //读取的行数
//            int i= 1;
//            int n ;
//            //获取文件内容 开始位置
//            while (( n=randomAccessFile.readByte())!=-1&&i<=4){
//                if(n=='\n'){
//                    startPosition = randomAccessFile.getFilePointer();
//                    i++;
//                }
//            }
//            startPosition = startPosition-1;
//            //获取文件内容结束位置
//            randomAccessFile.seek(randomAccessFile.length());
//            long endPosition = randomAccessFile.getFilePointer();
//            int j  = 1;
//            while (endPosition>=0&&j<=2){
//                endPosition--;
//                randomAccessFile.seek(endPosition);
//                if (randomAccessFile.readByte() == '\n'){
//                    j++;
//                }
//            }
//            endPosition = endPosition-1;
//
//
//            //这只保存上传文件的路径
//            String realPath = request.getServletContext().getRealPath("/")+"images";
//            File fileUpload = new File(realPath);
//            if (!fileUpload.exists()){
//                fileUpload.mkdir();
//            }
//
//            File saveFile = new File(realPath,text);
//            RandomAccessFile randomAccessFile1 = new RandomAccessFile(saveFile,"rw");
//            //从临时文件中读取上传文件的内容（根据起止位置获取）
//            randomAccessFile1.seek(startPosition);
//
//            while (startPosition<endPosition){
//                randomAccessFile1.write(randomAccessFile.readByte());
//                startPosition = randomAccessFile.getFilePointer();
//            }

            //关闭流，删除临时文件
//            randomAccessFile.close();
//            randomAccessFile1.close();


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  "success";
    }

}
