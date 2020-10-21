import java.io.IOException;

public class dayChar {
    public void Generator(int start, int end, int encounter,String E) throws IOException {
        DataScanner2 yash = new DataScanner2(60,599);
        Operator op = new Operator();
        for(int i = start; i<=end;i++){
            yash.runner(0.2,0.1,i,E);
            op.operator1(yash,true);
            op.operator2(yash,true);
            yash.domains.clear();
            yash.secdomains.clear();
            yash.B.clear();
        }
        op.writeExcel("DayVSLengthE"+encounter+".xls");
    }
}
