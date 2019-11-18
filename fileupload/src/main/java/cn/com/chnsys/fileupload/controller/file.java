package cn.com.chnsys.fileupload.controller;

import java.io.File;

/**
 * @Class: file
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-04 14:23
 */
public class file {

    public static void main(String[] args) {
        File file = new File("G:/demo.txt");
        if (!file.exists()){
            System.out.println("文件不存在，创建文件");
            file.mkdir();
            System.out.println(file.getName());

        }
    }

}
