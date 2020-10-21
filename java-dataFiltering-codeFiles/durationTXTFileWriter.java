import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class durationTXTFileWriter {
    ArrayList<Integer> nan = new ArrayList<Integer>(Arrays.asList(1,7,8,10,11,12,13,15,17,25,52,53,55,57,58,59,60,64,65,66,67,69,70,71,72,73,74,76,77,79,81));
    ArrayList<Integer> nanFiles = new ArrayList<Integer>();
    //
    //1,7,8,10,11,12,13,15,17,25,52,53,55,57,58,59,60,64,65,66,67,69,70,71,72,73,74,76,77,79,81
    public void runner() throws IOException {
        DataScanner2 yash = new DataScanner2(60,599);
        for(Integer nany:nan){
            nanFiles.add(nany-1);
        }
        for(int i = 0; i<=84;i++){
            if(!nanFiles.contains(i)){
                File myObj = new File("D:/HDD Files/Desktop/Domain Duration/Raw Durations/E2/durationsDay"+i+".txt");
                myObj.createNewFile();
                FileWriter myWriter = new FileWriter("D:/HDD Files/Desktop/Domain Duration/Raw Durations/E2/durationsDay"+i+".txt");
                yash.runner(0.2,0.1,i,"E4");
                myWriter.write("Duration");
                myWriter.write(System.lineSeparator());
                for(ArrayList<Double> arr:yash.secdomains){
                   myWriter.write(new Integer(arr.size()).toString());
                   myWriter.write(System.lineSeparator());
                }
                myWriter.close();
                yash.domains.clear();
                yash.secdomains.clear();
                yash.B.clear();

            }


        }

    }
}
