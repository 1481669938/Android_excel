package com.example.legion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class write_excel extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_write_excel);
//    }
    public static void main(String[] args) throws ParseException {
        //创建一个HSSF,对应一个excel
        HSSFWorkbook workbook = new HSSFWorkbook();
        //在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = workbook.createSheet("学生表");
        //在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        //创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFCell cell = row.createCell(0);
        cell.setCellValue("学号111");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("年龄");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("生日");
        cell.setCellStyle(style);

        //写入实体数据
        //      List list = DemoDaoImpl.getStudent();
        List list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        for (int i = 0; i < list.size(); i++)
        {
            row = sheet.createRow((int) i + 1);
            //     Student stu = (Student) list.get(i);
            //创建单元格，并设置值
            row.createCell(0).setCellValue(i);
            row.createCell(1).setCellValue("Jack");
            row.createCell(2).setCellValue(20);
            cell = row.createCell(3);
            cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        }
        //将文件存到指定位置
        try
        {
            FileOutputStream fout = new FileOutputStream("F:/学生表.xls");
            workbook.write(fout);
            fout.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
