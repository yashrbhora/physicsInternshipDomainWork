import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Operator {
    ArrayList<Integer> length = new ArrayList<Integer>();
    int g=1;
    int k=0;
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("Characteristics");
    XSSFRow r = sheet.createRow(0);
    XSSFCell cll = r.createCell(0);
    XSSFCell cll2 = r.createCell(1);
    XSSFCell cllsd = r.createCell(2);
    XSSFCell clln = r.createCell(3);
    XSSFCell cll3 = r.createCell(5);
    XSSFCell cll4 = r.createCell(6);
    XSSFCell cllsd1 = r.createCell(7);
    XSSFCell clln1 = r.createCell(8);
    XSSFCell radius = r.createCell(9);
    XSSFCell prop = r.createCell(11);
    XSSFCell nanornot =r.createCell(12);
    XSSFRow row;



    public Operator(){

        cll.setCellValue("Day");
        cll2.setCellValue("Mean Size");
        clln.setCellValue("Number of Domains");
        cllsd.setCellValue("Standard Deviation");

        cll3.setCellValue("Day");
        cll4.setCellValue("Mean Size");
        clln1.setCellValue("Number of Domains");
        cllsd1.setCellValue("Standard Deviation");
        radius.setCellValue("middleRadius");
        prop.setCellValue("Proportion");
        nanornot.setCellValue("Missing Data?");
    }

    public double average(){
        Integer sum = 0;
        for (Integer blu : length) {
            sum += blu;
        }
        double lsize=length.size();
        return sum.doubleValue() / lsize;
    }

    public double proportion(DataScanner2 obj){
        Integer sum = 0;
        for (Integer blu : length) {
            sum += blu;
        }
        double lsize=length.size();
        return sum.doubleValue() / obj.num;
    }

    public double std () {
        // Step 1:
        double mean = this.average();
        double temp = 0;

        for (int i = 0; i < length.size(); i++)
        {
            int val = length.get(i);

            // Step 2:
            double squrDiffToMean = Math.pow(val - mean, 2);

            // Step 3:
            temp += squrDiffToMean;
        }

        // Step 4:
        double meanOfDiffs = (double) temp / (double) (length.size());

        // Step 5:
        return Math.sqrt(meanOfDiffs);
    }

    public void adding(int add,boolean or, int day, String encounter, DataScanner2 obj) throws FileNotFoundException {
        if(or){row = sheet.createRow(g);}
        XSSFCell cell = row.createCell(add);
        XSSFCell cell2 = row.createCell(add+1);
        XSSFCell cell3 = row.createCell(add+2);
        XSSFCell cell4 = row.createCell(add+3);

        if(!or){
            ArrayList<Double> radius = new ArrayList<Double>();
            XSSFCell cellrad = row.createCell(9);
            File file = new File("D:\\HDD Files\\Desktop\\PSP Data\\"+encounter+" Data\\PSP_Radius_notime_1min\\Radius_"+encounter+"_day"+day+".csv");
            Scanner sc = new Scanner(file,"UTF-8");
            while(sc.hasNextDouble()){
                radius.add(sc.nextDouble());
            }
            if(day==120){
                cellrad.setCellValue("Nope");
            }else{cellrad.setCellValue((radius.get(719) + radius.get(720))/2);}

            XSSFCell cellprop = row.createCell(11);
            cellprop.setCellValue(this.proportion(obj));
            XSSFCell miss = row.createCell(12);
            if(obj.line){
                miss.setCellValue("Yes");
            }else{miss.setCellValue("No");}
        }
        if(or){
            cell.setCellValue(k);
        }else{
            cell.setCellValue(k);
        }
        cell3.setCellValue(this.std());
        cell2.setCellValue(this.average());

        cell4.setCellValue(length.size());
    }
    public void operator1(DataScanner2 obj,boolean or) throws FileNotFoundException {
        if(or){
            for(ArrayList<Double> dis: obj.domains){
                length.add(dis.size());
            }
        }else{
            length = obj.invLength;
        }
        this.adding(0,true,5,"champloo", obj);
        length.clear();
    }
    public void operator2(DataScanner2 obj,boolean or, int day, String E) throws FileNotFoundException {
        if(or){
            for(ArrayList<Double> dis: obj.secdomains){
                length.add(dis.size());
            }
        }else{
            length = obj.invLength2;
        }
        this.adding(5,false, day, E,obj);
        length.clear();
        g++;
        k++;
    }

    public void writeExcel(String filename) throws IOException {
        workbook.write(new FileOutputStream(filename));
        workbook.close();
    }
}



//        int g=1;
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet sheet = workbook.createSheet("Characteristics");
//        XSSFRow r = sheet.createRow(0);
//        XSSFCell cll = r.createCell(0);
//        XSSFCell cll2 = r.createCell(1);
//        cll.setCellValue("Domain1");
//        cll2.setCellValue("Size");
//
//        for(ArrayList<Double> dis: obj.domains){
//            XSSFRow row = sheet.createRow(g);
//            XSSFCell cell = row.createCell(0);
//            XSSFCell cell2 = row.createCell(1);
//            cell.setCellValue(g);
//            cell2.setCellValue(dis.size());
//            g++;
//        } workbook.write(new FileOutputStream("Length Data"));
//        workbook.close();