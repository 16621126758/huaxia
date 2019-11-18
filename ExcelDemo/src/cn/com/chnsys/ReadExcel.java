package cn.com.chnsys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @Class: ReadExcel
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-13 15:46
 */
public class ReadExcel {

    public static void main(String[] args) throws IOException {
        //InputStream inputStream = new FileInputStream(new File("C:\\Users\\86166\\Desktop"));

        Workbook workbook = WorkbookFactory.create(new File("C:\\Users\\86166\\Desktop\\北京8.xls"));
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        String cellValue = cell.getStringCellValue();
        System.out.println("第一行第一列的值为--"+cellValue);
    }
}
