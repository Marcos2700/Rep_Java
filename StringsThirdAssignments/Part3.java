
/**
 * Write a description of class Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part3 {
    public void processGenes(StorageResource sr){
        int more9Count = 0;
        int cgCount = 0;
        int maxLength = 0;
        for(String s : sr.data()){
            int sLength = s.length();
            System.out.println("String with length major to 9");
            if(sLength > 9){
                System.out.println(s);
                more9Count++;
            }
            float cgRatio = cgRatio(s);
            System.out.println("String with cg ratio major to 0.35");
            if(cgRatio > 0.35){
                System.out.println(s);
                cgCount++;
            }
            if(sLength > maxLength){
                maxLength = sLength;
            }
        }
        System.out.println("The number of strings with length major to 9 is: "+more9Count);
        System.out.println("The number of string with cg ratio major to o.35 is: "+cgCount);
    }
    public float cgRatio(String dna){
        int startIndex = 0;
        float count = 0;
        int dnaSize = dna.length();
        while(true){
            if(startIndex > (dnaSize-1)){
                break;
            }      
            int c = dna.indexOf("C", startIndex);
            int g = dna.indexOf("G", startIndex);
            int min = Math.min(c,g);
            if(min == -1 && (c>-1||g>-1)){
                min = Math.max(c,g);
            }
            if(min==-1){
                break;
            }
            //System.out.println(min+" "+c+" "+g+" "+startIndex+" "+count);
            String s = dna.substring(min, min+1);
            //System.out.println(s);
            if(s.equals("C") || s.equals("G")){
                count=count+1;
            }
            startIndex = min + 1;
        }
        return count/dnaSize;
    }
}
