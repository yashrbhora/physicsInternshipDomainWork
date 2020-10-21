import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;

public class meanFinder {
    String encounter;
    public meanFinder(String Encounter){
        encounter=Encounter;
    }
    ArrayList<Integer> length = new ArrayList<Integer>();
    int g=1;
    int k=1;
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("DayVSMean"+encounter);
    XSSFRow r = sheet.createRow(0);
    XSSFCell cll = r.createCell(0);
    XSSFCell cll2 = r.createCell(1);
    XSSFCell cllstd = r.createCell(2);
    public meanFinder(){
        cll.setCellValue("Day");
        cll2.setCellValue("Mean Size");
        cllstd.setCellValue("Standard Deviation");
    }
    public double average(){
        Integer sum = 0;
        for (Integer blu : length) {
            sum += blu;
        }
        double lsize=length.size();
        return sum.doubleValue() / lsize;
    }
}
