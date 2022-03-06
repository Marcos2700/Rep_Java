
/**
 * Write a description of class Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class Part2 {
    public String findSimpleGene(String dna, int startCodon, int stopCodon){
        dna.toUpperCase();
        if(startCodon == -1){
            return "";
        }
        if((startCodon - stopCodon) % 3 == 0){
            return dna.substring(startCodon, stopCodon + 3);
        }
        else{
            return "";
        }
    }
    public void testSimpleGene(){
        String gene1, gene2, gene3, gene4, gene5, gene6, start, stop;
        gene1 = "ACTATGDAEGCTTDATAAGHJ";
        gene2 = "TGDASDFTAASFDTAA";
        gene3 = "ATGDFGHJYUTAAGFDSWE";
        gene4 = "DFFEETFGFRTGADFGBGDT";
        gene5 = "TDFAATTGAATGGTFAWETRAFDRTAAGFDSTG";
        gene6 = "ASDGTEATGDSTRESDFTRFGTDTAADFGTFF";
        String gene = findSimpleGene(gene5, gene5.indexOf("ATG"), gene5.indexOf("TAA"));
        System.out.println("Gene = " + gene);
    }
}
