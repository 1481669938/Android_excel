package com.example.legion;

import android.os.Environment;
import android.util.Log;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class read {
    public static List<Map<String, String>> readExcel(String columns[]) {
        Log.e("yy","开始");
//        String logFilePath = Environment.getExternalStorageDirectory() + File.separator ;
//        String logFilePath = Environment.getExternalStorageDirectory() + File.separator + "Visitor";
//        File file = new File(logFilePath,"test.xls");
//        String filePath=file.getAbsolutePath();
        String filePath=activity_select.path;

        Log.e("yy",filePath);
        Sheet sheet = null;
        Row row = null;
        Row rowHeader = null;
        List<Map<String, String>> list = null;
        String cellData = null;
        Workbook wb = null;
        if (filePath == null) {
            Log.e("yy","filePath is null");
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        Log.e("yy",extString);
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            Log.e("yy",extString);
//            try{
//                //fis实例化，代码略
//
//                long size = is.size();
//            }catch(IOException e){
//                e.printStackTrace();
//            }finally{
//                if(is != null){
//                    is.close();
//                }
//            }

            if (".xls".equals(extString)) {
                wb = new HSSFWorkbook(is);
                Log.e("yy",".xls");
            } else if (".xlsx".equals(extString)) {
                wb = new XSSFWorkbook(is);
                Log.e("yy",".xlsx");
            } else {
                wb = null;
            }
            if (wb != null) {
                Log.e("yy","wb");
                // 用来存放表中数据
                list = new ArrayList<Map<String, String>>();
                // 获取第一个sheet
                sheet = wb.getSheetAt(0);
                // 获取最大行数
                int rownum = sheet.getPhysicalNumberOfRows();
                Log.e("yy",String.valueOf(rownum));
                // 获取第一行
                rowHeader = sheet.getRow(0);
                row = sheet.getRow(0);
                // 获取最大列数
                int colnum = row.getPhysicalNumberOfCells();
                Log.e("yy",String.valueOf(colnum));
                for (int i = 1; i < rownum; i++) {
                    Map<String, String> map = new LinkedHashMap<String, String>();
                    row = sheet.getRow(i);
                    if (row != null) {
                        for (int j = 0; j < colnum; j++) {
                            if(columns[j].equals(getCellFormatValue(rowHeader.getCell(j)))){
                                cellData = (String) getCellFormatValue(row.getCell(j));
                                map.put(columns[j], cellData);
                                /*DecimalFormat df = new DecimalFormat("#");
                                System.out.println(    df.format(cellData));*/
                                Log.e("yy","cellData="+cellData);
                                Log.e("yy","map="+map);
                            }
                        }
                    } else {
                        break;
                    }
                    list.add(map);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**	获取单个单元格数据
     * @param cell
     * @return
     * @author lizixiang ,2018-05-08
     */
    public static Object getCellFormatValue(Cell cell) {
        Object cellValue = null;
        if (cell != null) {
            // 判断cell类型
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA: {
                    // 判断cell是否为日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        // 转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    } else {
                        // 数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue;

    }
}
