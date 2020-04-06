package com.example.legion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.InputStream;

public class read_excel extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_read_excel);
//    }
    public static void main(String[] args) throws Exception {
        InputStream inp = new FileInputStream("F:\\项目文件\\固定资产卡片.xls");
        POIFSFileSystem fs = new POIFSFileSystem(inp);
        HSSFWorkbook workbook = new HSSFWorkbook(fs);
        HSSFSheet sheet = workbook.getSheetAt(0);
        for (int rownum=0;rownum<=sheet.getLastRowNum();rownum++){
            Row sheetRow = sheet.getRow(rownum);
            if(sheetRow==null){
                continue;
            }
            //遍历列cell
            for (int cellnum=0;cellnum<=sheetRow.getLastCellNum()-1;cellnum++){
                Cell cell = sheetRow.getCell(cellnum);
                if(cell==null){
                    System.out.print( " null ");
                    continue;
                }
                System.out.print( "  "+getValue(cell));
            }
            System.out.println();

        }
        }

//

    private static String getValue(Cell cell){
        if(cell.getCellType()==HSSFCell.CELL_TYPE_BOOLEAN){
            return String.valueOf(cell.getBooleanCellValue());
        }else if(cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
            return String.valueOf(cell.getNumericCellValue());
        }else{
            return String.valueOf(cell.getStringCellValue());
        }
    }
}
