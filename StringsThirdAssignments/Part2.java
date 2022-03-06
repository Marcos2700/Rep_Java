
/**
 * Write a description of class Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
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
            System.out.println(min+" "+c+" "+g+" "+startIndex+" "+count);
            String s = dna.substring(min, min+1);
            System.out.println(s);
            if(s.equals("C") || s.equals("G")){
                count=count+1;
            }
            startIndex = min + 1;
        }
        return count/dnaSize;
    }
    public void testCgRatio(){
        String dna = "CAFRGCASCGGAFDC";
        float ratio = cgRatio(dna);
        System.out.println("ratio: "+ratio);
    }
}
