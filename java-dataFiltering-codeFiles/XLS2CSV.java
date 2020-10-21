// code from https://dzone.com/articles/the-programmers-way-to-convert-excel-to-csv by Jay Sridhar
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class XLS2CSV {
    public void converter(String sourceFile, String targetFile) throws IOException, InvalidFormatException {
        Workbook wb = new XSSFWorkbook(new File(sourceFile));
        DataFormatter formatter = new DataFormatter();
        PrintStream out = new PrintStream(new FileOutputStream("D:\\HDD Files\\Desktop\\PSP Data\\"+targetFile),
                true, "UTF-8");
        for (Sheet sheet : wb) {
            for (Row row : sheet) {
                boolean firstCell = true;
                for (Cell cell : row) {
                    if ( ! firstCell ) out.print(',');
                    String text = formatter.formatCellValue(cell);
                    out.print(text);
                    firstCell = false;
                }
                out.println();
            }
        }
    }
}
