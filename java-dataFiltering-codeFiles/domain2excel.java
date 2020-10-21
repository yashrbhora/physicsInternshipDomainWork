import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.ArrayList;

public class domain2excel {
    ArrayList<Integer> indeX2 = new ArrayList<Integer>();
    ArrayList<Integer> indeX1 = new ArrayList<Integer>();
    ArrayList<Integer> indeXAl = new ArrayList<Integer>();

    WritingExcel l = new WritingExcel();
    XLS2CSV gappia = new XLS2CSV();
    public void toExcel(DataScanner2 obj) throws IOException, InvalidFormatException {
        for(int j=0; j<obj.domains.size(); j++){
            for(int i=0; i<obj.domains.get(j).size(); i++){
                indeX1.add(obj.B.indexOf(obj.domains.get(j).get(i)));
            }
        }

        for(int j=0; j<obj.secdomains.size(); j=j+2){
            for(int i=0; i<obj.secdomains.get(j).size(); i++){
                indeX2.add(obj.B.indexOf(obj.secdomains.get(j).get(i)));
            }
        }

        for(int j=1; j<obj.secdomains.size(); j=j+2){
            for(int i=0; i<obj.secdomains.get(j).size(); i++){
                indeXAl.add(obj.B.indexOf(obj.secdomains.get(j).get(i)));
            }
        }
        l.Writer(obj.B, indeX1,"DaData1.xls");
        l.Writer(obj.B, indeX2,"DaData2a.xls");
        l.Writer(obj.B,indeXAl,"DaData2b.xls");

        gappia.converter("DaData1.xls","Domains1.csv");
        gappia.converter("DaData2a.xls","Domains2a.csv");
        gappia.converter("DaData2b.xls","Domains2b.csv");
    }
}
