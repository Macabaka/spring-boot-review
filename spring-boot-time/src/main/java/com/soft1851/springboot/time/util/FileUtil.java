package com.soft1851.springboot.time.util;

import com.soft1851.springboot.time.model.Student;
import com.soft1851.springboot.time.repository.StudentRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/17 01:00
 * @Description:
 */
@Component
public  class FileUtil {

    @Resource
    private  StudentRepository studentRepository;

   public  void getMessage(){
        //文件转换
//        File file = null;
//       InputStream inputStream= null;
//       //判断传入文件不为空
//        if (!("".equals(multipartFile) || multipartFile.getSize() <= 0)) {
//            try {
//                inputStream = multipartFile.getInputStream();
//                file = new File(multipartFile.getOriginalFilename());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        //开始获取数据
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
       studentRepository.saveAll(studentList);
    }

//    private static void inputStreamToFile(InputStream inputStream, File file) {
//        try {
//            OutputStream os = new FileOutputStream(file);
//            int byteRead = 0;
//            byte[] buffer = new byte[8192];
//            while ((byteRead = inputStream.read(buffer, 0, 8192)) != -1) {
//                os.write(buffer,0,byteRead);
//            }
//            os.close();
//            inputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
