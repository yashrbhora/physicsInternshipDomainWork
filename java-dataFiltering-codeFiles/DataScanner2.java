import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataScanner2 {
    ArrayList<String> Bi = new ArrayList<String>();
    ArrayList<Integer> invLength = new ArrayList<Integer>();
    ArrayList<Integer> invLength2 = new ArrayList<Integer>();
    ArrayList<ArrayList<Double>> domains = new ArrayList<ArrayList<Double>>();
    ArrayList<ArrayList<Double>> secdomains = new ArrayList<ArrayList<Double>>();
    ArrayList<Double> B = new ArrayList<Double>(Bi.size()); //might be redundant
    double Mx; int Mxt; double Mn; int Mnt; double nan; int Nan; int per; boolean needMax; int initi; int termi; boolean first=true;
    int y; double range; int size=1; boolean term = false; int req; int dcount; int sdcount; int c=0;
    int line;
    public DataScanner2(int req, int per) {

        this.req=req;
        this.per=per;
    }

    public void readFile(int day,String encounter) throws FileNotFoundException {
        File file = new File("D:\\HDD Files\\Desktop\\PSP Data\\"+encounter+" Data\\Bmag "+encounter+" notime\\Bmag_"+encounter+"_day"+day+".csv");
        Scanner sc = new Scanner(file,"UTF-8");
        //April5Y.txt"
        //E2 Data\\BmagE2_notime\\Bmag_E2_day"+day+".csv"
        while(sc.hasNextDouble()){

            B.add(sc.nextDouble());
        }
    }

    public void readFile2() throws IOException {
        File file = new File("D:\\HDD Files\\Desktop\\Data file.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            Bi.add(st);
        }
        for(int i = 0; i<Bi.size(); i++){
            B.add(Double.valueOf(Bi.get(i)));
            line++;
        }
    }


    public boolean isExtrema(ArrayList<Double> array, int index){
        if(array.get(index)> Mx){
            Mx=array.get(index);
            Mxt=index;
            return true;
        }
        if(array.get(index)<Mn){
            Mn=array.get(index);
            Mnt=index;
            return true;
        }
        return false;
    }

    public boolean rangeChecker(){
        if(Mx-Mn<= range*Mn){
            return true;
        }else {
            return false;
        }
    }
    public void reset(){
        Mx=nan;
        Mn=nan;
        Mxt=Nan;
        Mnt=Nan;
        size=1;
        term=false;

    }

    public boolean doubleComp(double x, double y){
        if(x>y){
            Mx=x;
            Mn=y;
        }else{ Mx=y; Mn=x;}

        if(Mx-Mn<= range*Mn){
            return true;
        }else {
            return false;
        }
    }

    public void findNewExtrema(boolean Max, ArrayList<Double> array){

        if(Max){
            int spread=y-Mxt;
            int temp=Mxt;
            Mx=array.get(temp+1);
            Mxt=temp+1;
            for(int x=2; x<spread;x++){
                if(array.get(temp+x)>Mx){
                    Mx=array.get(temp+x);
                    Mxt=temp+x;
                }
            }

        }else{
            int spread=y-Mnt;
            int temp=Mnt;
            Mn=array.get(temp+1);
            Mnt=temp+1;
            for(int x=2; x<spread;x++){
                if(array.get(temp+x)<Mn){
                    Mn=array.get(temp+x);
                    Mnt=temp+x;
                }
            }
        }
    }

    public boolean inBound(ArrayList<Double> array){
        if(y-Mnt<=per && y-Mxt<=per){
            return true;
        } else if(y-Mnt>=per) {
            needMax = false;
            return false;///need to find new minimum
        }else {
            needMax=true; return false;}///need to find new maximum
    }

    public void findDomain2(double newRange, ArrayList<Double> domain){
        this.range=newRange;
        int i=0; int counter=domain.size()-1;
        while(i<counter){
            y=i+1;
            if(this.doubleComp(domain.get(i),domain.get(y))){
                y++; size++;                                                        //need to reset size at termination
                while(!term){
                    if(y == domain.size()){
                        break;
                    }
                    this.isExtrema(domain,y);
                    if(size>=per){
                        if(!this.inBound(domain)){ //checks whether Mxt and Mnt are within per range
                            this.findNewExtrema(needMax,domain);
                        }
                    }
                    if(this.rangeChecker()){
                        y++; size++;
                    }else{
                        term=true;
                    }//termination of domain
                }

                if(size>=req){
                    ArrayList<Double> list = new ArrayList<Double>(size);
                    for (int j = 0; j < size; j++) {
                        list.add(j, domain.get(i + j));
                    }
                    secdomains.add(list); sdcount++;
                    if(!first){
                        initi = B.indexOf(list.get(0));
                        invLength2.add(initi-termi-1);
                        termi= B.indexOf(list.get(list.size()-1));
                    }else{
                        if(B.indexOf(list.get(0))!=0){
                            invLength2.add(B.indexOf(list.get(0))-1);
                        }
                        termi= B.indexOf(list.get(list.size()-1));
                        first=false;
                    }
                }
                i=y;
                this.reset();
            }else{i=y;}
        }
        first=true;
//        int size= secdomains.size();
//        if(size>0){
//            ArrayList<Double> last=secdomains.get(size-1);
//            if(B.indexOf(last.get(last.size()-1))!=B.size()-1){
//                invLength2.add(B.size()-1-termi);
//            }
//        }

    }

    public void findDomain(int day, String encounter) throws IOException {
        this.readFile(day,encounter);
        int i=0; int counter=B.size()-1;
        while(i<counter){
            y=i+1;
            if(this.doubleComp(B.get(i),B.get(y))){
                y++; size++;                                                        //need to reset size at termination
                while(!term){
                    if(y == B.size()){
                        break;
                    }
                    this.isExtrema(B,y);
                    if(this.rangeChecker()){
                        y++; size++;
                    }else{
                        term=true;
                    }                                                                       //termination of domain
                }
                if(size>=req){
                    ArrayList<Double> list = new ArrayList<Double>(size);

                    for (int j = 0; j < size; j++) {
                        list.add(j, B.get(i + j));
                    }
                    domains.add(list); dcount++;

                    if(!first){
                        initi = B.indexOf(list.get(0));
                        invLength.add(initi-termi-1);
                        termi= B.indexOf(list.get(list.size()-1));
                    }else{
                        if(B.indexOf(list.get(0))!=0){
                            invLength.add(B.indexOf(list.get(0))-1);
                        }
                        termi= B.indexOf(list.get(list.size()-1));
                        first=false;
                    }
                }
                i=y;
                this.reset();
            }else{i=y;}
        }
        first=true;
//        int size= domains.size();
//        if(size>0){
//            ArrayList<Double> last=domains.get(size-1);
//            if(B.indexOf(last.get(last.size()-1))!=B.size()-1){
//                invLength.add(B.size()-1-termi);
//            }
//        }

    }

    public void runner(double thres1, double thres2, int day, String encounter) throws IOException {
        this.range=thres1; //req is minimum size of domain needed per need to subtract one /for some reason, per and req isn't making a difference.
        //need to decode
        this.findDomain(day,encounter);
        this.dcount=0;
        for(ArrayList<Double> dis: this.domains){
            this.findDomain2(thres2,dis);
        }
    }

}
//    int size= secdomains.size();
//    ArrayList<Double> last=secdomains.get(size-1);
//
//        if(B.indexOf(last.get(last.size()-1))!=B.size()-1){
//                invLength2.add(B.size()-1-termi);
//                }