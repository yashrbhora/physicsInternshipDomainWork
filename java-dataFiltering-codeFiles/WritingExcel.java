import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WritingExcel {
    ArrayList<Double> time = new ArrayList<Double>();
    public void Writer(ArrayList<Double> magB, ArrayList<Integer> index, String fileName) throws IOException {
        File file = new File("D:\\HDD Files\\Desktop\\PSP Data\\April5X.txt");
        Scanner sc = new Scanner(file,"UTF-8");
        while(sc.hasNextDouble()){
            time.add(sc.nextDouble());
        }//creates timearray
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("DataTable");
        XSSFRow r = sheet.createRow(0);
        XSSFCell cll = r.createCell(0);
        XSSFCell cll2 = r.createCell(1);
        cll.setCellValue("Time");
        cll2.setCellValue("Magnetic Field Magnitude");
        for(int i=1; i<=index.size();i++){
            XSSFRow row = sheet.createRow(i);
            XSSFCell cell = row.createCell(0);
            XSSFCell cell2 = row.createCell(1);
            cell.setCellValue(time.get(index.get(i-1)));
            cell2.setCellValue(magB.get(index.get(i-1)));
        }
        
        workbook.write(new FileOutputStream(fileName));
        workbook.close();
    }
}
