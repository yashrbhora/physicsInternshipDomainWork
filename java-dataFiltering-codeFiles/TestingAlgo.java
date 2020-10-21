import java.util.ArrayList;
import java.util.*;

public class TestingAlgo {
    public boolean tester(ArrayList<ArrayList<Double>> arr, boolean cov){
        ArrayList<ArrayList<Double>> largeDoms = new ArrayList<ArrayList<Double>>();
        ArrayList<List<Double>> splicedDoms = new ArrayList<List<Double>>();
        boolean pass=true;
        if(cov){
           for(ArrayList<Double> arr1: arr){
                    if(!(Collections.max(arr1)-Collections.min(arr1)<=0.2*Collections.min(arr1))){
                        System.out.println("Test failed");
                        pass=false;
                        break;
                    }
           }
           if(pass){System.out.println("Test Passed!");}

        }

        for(ArrayList<Double> arr1: arr){
            if (arr1.size()>600){
                largeDoms.add(arr1);
            }
        }

        if(!cov){
            for(ArrayList<Double> arr1: largeDoms){
                int siz = arr1.size()/600;
                for(int p = 0; p<siz+1; p++){
                    if(p==0){
                        splicedDoms.add(arr1.subList(0,600));
                    }else{
                        if((p+1)*599>arr1.size()){
                            splicedDoms.add(arr1.subList(p*599+1,arr1.size()));
                        }else {
                            splicedDoms.add(arr1.subList(p * 599 + 1, (p + 1) * 599));
                        }
                    }
                }

//
            }
            for(List<Double> arr1: splicedDoms){
                if(!(Collections.max(arr1)-Collections.min(arr1)<=0.1*Collections.min(arr1))){
                    System.out.println("Test failed");
                    pass=false;
                    break;
                }
            }
            if(pass){System.out.println("Test Passed!");}
        }

        if(pass){return true;}
        return false;
    }
}
