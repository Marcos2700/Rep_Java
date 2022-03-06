
/**
 * Write a description of class Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        while (currIndex != -1){
            if((currIndex - startIndex)%3 == 0){
                return currIndex;
            }
            else{
                currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return dna.length();
    }
    
    public void testFindStopCodon(){
                //01234567890123456789012345678901234567890
    String dna = "aqweasATGadasfrjgkhjutsdTAADSDTAGRERASDAS";
    int test = findStopCodon(dna, 0, "TAA");
    if(test != 24){
        System.out.println("error en 0"+test);
    }
    test = findStopCodon(dna, dna.indexOf("ATG"), "TAG");
    if(test != 30){
        System.out.println("error en ATG index"+test);
    }
    test = findStopCodon(dna, 0, "TGA");
    if(test != 41){
        System.out.println("error en busqueda"+test);
    }
    }
    
    public String findGene(String dna, int pos){
        int startIndex = dna.indexOf("ATG", pos);
        if(startIndex == -1){
            return "";
        }
        int taaStop = findStopCodon(dna, startIndex, "TAA");
        int tagStop = findStopCodon(dna, startIndex, "TAG");
        int tgaStop = findStopCodon(dna, startIndex, "TGA");
        int aux = Math.min(taaStop, tagStop);
        int minIndex = Math.min(aux, tgaStop);
        if(minIndex == dna.length()){
            return "";
        }
        return dna.substring(startIndex, minIndex+3);
    }
    
    public void testFindGene(){
        String dna1, dna2, dna3, dna4, dna5, gene;
        dna1 = "DASDEATGFREWQAVFGTAAGTFTGADERTAGDFR";
        dna2 = "FEATGDFTAADTAGDFSTGA";
        dna3 = "ASDFATGFRTAAGFTAGFRESFRETGAFD";
        dna4 = "ASDFDTAAGRATAGFDETGAFDFE";
        dna5 = "ADSATGDSTAASDTAGDSSDDTGAFSDF";
        
        gene = findGene(dna1, 0);
        System.out.println("Gene1: "+gene);
        gene = findGene(dna2, 0);
        System.out.println("Gene2: "+gene);
        gene = findGene(dna3, 0);
        System.out.println("Gene3: "+gene);
        gene = findGene(dna4, 0);
        System.out.println("Gene4: "+gene);
        gene = findGene(dna5, 0);
        System.out.println("Gene5: "+gene);
    }
    public void printAllGenes(String dna){
        int startIndex = 0;
        while(true){
            String currGene = findGene(dna, startIndex);
            if(currGene.isEmpty()){
                break;
            }
            System.out.println(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
    }
    public StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        while(true){
            String currGene = findGene(dna, startIndex);
            if(currGene.isEmpty()){
                break;
            }
            geneList.add(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
        return geneList;
    }
    public void testGetAllGenes(String dna){
        System.out.println("Testing getAllGenes");
        StorageResource genes = getAllGenes(dna);
        for(String s : genes.data()){
            System.out.println(s);
        }
    }
    public void test(){
        String dna = "ADESATGDSFFDETAGDFATGDFRSDETAAFDATGDFESQETGAFD";
        testGetAllGenes(dna);
    }
    public void testPrintAllGenes(){
        String dna1, dna2;
        dna1 = "ASATGFDEDFGTAADFATGDERADETAG";
        dna2 = "ADESATGDSFFDETAGDFATGDFRSDETAAFDATGDFESQETGAFD";
        printAllGenes(dna1);
        printAllGenes(dna2);
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
    public void testCgRatio(){
        String dna = "CAFRGCASCGGAFDC";
        float ratio = cgRatio(dna);
        System.out.println("ratio: "+ratio);
    }
    public void processGenes(StorageResource sr){
        int more9Count = 0;
        int cgCount = 0;
        int maxLength = 0;
        for(String s : sr.data()){
            int sLength = s.length();
            if(sLength > 60){
                System.out.println("String with length major to 60");
                System.out.println(s);
                more9Count++;
            }
            float cgRatio = cgRatio(s);
            if(cgRatio > 0.35){
                System.out.println("String with cg ratio major to 0.35");
                System.out.println(s);
                cgCount++;
            }
            if(sLength > maxLength){
                maxLength = sLength;
            }
        }
        System.out.println("The number of strings with length major to 9 is: "+more9Count);
        System.out.println("The number of string with cg ratio major to o.35 is: "+cgCount);
        System.out.println("dna length is: "+maxLength);
    }
    public void testProcessGenes(){
        StorageResource sr = new StorageResource();
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        dna = dna.toUpperCase();
        sr = getAllGenes(dna);
        processGenes(sr);
        printAllGenes(dna);
        int manyTimes = howMany("CTG", dna);
        System.out.println("Apariciones de CTG: "+manyTimes);
    }
    public int howMany(String stringa, String stringb){
        int times = 0;
        int startIndex = 0;
        while(true){
            String word = findWord(stringa, stringb, startIndex);
            if(word.isEmpty()){
                break;
            }
            times++;
            startIndex = stringb.indexOf(word, startIndex) + word.length();
        }
        return times;
    }
    public String findWord(String stringa, String stringb, int pos){
        int startIndex = stringb.indexOf(stringa, pos);
        int sizeSA = stringa.length();
        if(startIndex == -1){
            return "";
        }
        return stringb.substring(startIndex, startIndex+sizeSA);
    }
}
