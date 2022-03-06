
/**
 * Write a description of class Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class Part1 {
    public String findSimpleGene(String dna){
        int start = dna.indexOf("ATG");
        if(start == -1){
            return "";
        }
        int stop = dna.indexOf("TAA", start+3);
        if((start - stop) % 3 == 0){
            return dna.substring(start, stop+3);
        }
        else{
            return "";
        }
    }
    public void testSimpleGene(){
        String gene1, gene2, gene3, gene4, gene5, gene6, gene7;
        gene1 = "ACTATGDAEGCTTDATAAGHJ";
        gene2 = "TGDASDFTAASFDTAA";
        gene3 = "ATGDFGHJYUTAAGFDSWE";
        gene4 = "DFFEETFGFRTGADFGBGDT";
        gene5 = "TDFAATTGAATGGTFAWETRAFDRTAAGFDSTG";
        gene6 = "ASDGTEATGDSTRESDFTRFGTDTAADFGTFF";
        gene7 = "AAATGCCCTAACTAACTAGATTAAGAAACC";
        String gene = findSimpleGene(gene7);
        System.out.println("Gene = " + gene);
        
    }
}
