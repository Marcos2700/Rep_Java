
/**
 * Write a description of class Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
    public void testPrintAllGenes(){
        String dna1, dna2;
        dna1 = "ASATGFDEDFGTAADFATGDERADETAG";
        dna2 = "ADESATGDSFFDETAGDFATGDFRSDETAAFDATGDFESQETGAFD";
        printAllGenes(dna1);
        printAllGenes(dna2);
    }
}
