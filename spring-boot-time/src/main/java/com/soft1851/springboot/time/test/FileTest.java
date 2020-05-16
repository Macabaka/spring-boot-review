package com.soft1851.springboot.time.test;

import com.soft1851.springboot.time.model.Student;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/16 23:58
 * @Description:
 */
public class FileTest {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Workbook wb =null;
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\test.xlsx");
            wb = new XSSFWorkbook(fileInputStream);
            Sheet sheet = wb.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for (int i = 0; i <= rowNum; i++) {
                Row row = sheet.getRow(i);
                int colNum = row.getLastCellNum();
                for (int j = 0; j < colNum; j++) {
                    Cell cell = row.getCell(j);
                    if (j==3){
                        studentList.add(Student.builder().name(cell.toString()).build());
                        System.out.println(cell.toString());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
