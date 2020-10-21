import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataScannerTestDrive {

    public static void main(String[] args) throws IOException, InvalidFormatException {
//       Selective data
        DataScanner2 yash = new DataScanner2(60,599);
//        ArrayList<Integer> nan = new ArrayList<Integer>(Arrays.asList(1,7,8,10,11,12,13,15,17,25,52,53,55,57,58,59,60,64,65,66,67,69,70,71,72,73,74,76,77,79,81));
//        durationTXTFileWriter yash = new durationTXTFileWriter();
//        yash.runner();
        //1,7,8,10,11,12,13,15,17,25,52,53,55,57,58,59,60,64,65,66,67,69,70,71,72,73,74,76,77,79,81
//        DataScanner2 yash = new DataScanner2(60,599);
        yash.runner(0.2,0.1,10,"E4");
        domain2excel mike = new domain2excel();
        mike.toExcel(yash);
//        for(ArrayList<Double> arr:yash.secdomains){
//            System.out.println(arr.size());
//        }
//        ArrayList<Integer> nanFiles = new ArrayList<Integer>();
//        for(Integer nany:nan){
//            nanFiles.add(nany-1);
//        }
//        for(int i = 0; i<=84;i++){
//            if(!nanFiles.contains(i)){
//                yash.runner(0.2,0.1,i);
//
//                yash.domains.clear();
//                yash.secdomains.clear();
//                yash.B.clear();
//            }
//        }
//        for(int i = 0; i<=84;i++){
//            if(!nanFiles.contains(i)){
//                yash.runner(0.2,0.1,i);
//                for(ArrayList<Double> arr : yash.domains){
//                    System.out.println(arr.size());
//                }
//                yash.domains.clear();
//                yash.secdomains.clear();
//                yash.B.clear();
//            }
//        }
        //Characteristic Data
//        dayChar dax = new dayChar();
//        dax.Generator(0,120,4,"E4");
        //algotester
//        WritingExcel l = new WritingExcel();
//        int ind = 0;
//        domain2excel mike = new domain2excel();
//        DataScanner2 yash = new DataScanner2(60,599);
//
//        yash.runner(0.2,0.1,45);
//        TestingAlgo alg = new TestingAlgo();
//        alg.tester(yash.domains,true);
//        alg.tester(yash.secdomains, false);
//        mike.toExcel(yash);
//        for(int i = 2; i<=30;i++){
//            yash.runner(i*0.01,i*0.005);
//            op.operator1(yash,true);
//            op.operator2(yash,true);
//            invop.operator1(yash,false);
//            invop.operator2(yash,false);
//            yash.domains.clear();
//            yash.secdomains.clear();
//        }
//        op.writeExcel("Length Data.xls");
//        invop.writeExcel("invLength Data.xls");


//        System.out.println("There are " + yash.domains.size() + " domains:");
//        for(int h = 0; h<yash.domains.size(); h++) {
//            System.out.println(yash.domains.get(h));
//        }
////
////
//        System.out.println("--------------------------------------------------------------------------");
//        System.out.println("There are " + yash.secdomains.size() + " domains:"); //need to fix for sec domain
//        for(int h = 0; h<yash.secdomains.size(); h++) {
//            System.out.println(yash.secdomains.get(h));
//        }
//

//        for(int h=0; h<indeX.size(); h++){
//            System.out.print(indeX.get(h));
//            System.out.print(",");
//            ind++;
//        }
//
//        System.out.println(" ");
//        System.out.println("There are "+ind+" values.");
//
//        l.Writer(yash.B,indeX1,"DaData1.xls");
//        l.Writer(yash.B, indeX,"DaData.xls");
//        XLS2CSV gappia = new XLS2CSV();
//        gappia.converter("DaData1.xls","Domains1.csv");
//        gappia.converter("DaData.xls","Domains.csv");

    }
}
