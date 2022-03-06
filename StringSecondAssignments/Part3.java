
/**
 * Write a description of class Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
    public int countGenes(String dna){
        int startIndex = 0;
        int genesCount = 0;
        while(true){
            String currGene = findGene(dna, startIndex);
            if(currGene.isEmpty()){
                break;
            }
            genesCount++;
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
        return genesCount;
    }
    public void testCountGenes(){
        int count;
        count = countGenes("ASATGFDEDFGTAADFATGDERADETAG");
        System.out.println("test1: "+count);
        printAllGenes("ASATGFDEDFGTAADFATGDERADETAG");
        System.out.println("////////////////////////////////");
        count = countGenes("ADESATGDSFFDETAGDFATGDFRSDETAAFDATGDFESQETGAFD");
        System.out.println("test2: "+count);
        printAllGenes("ADESATGDSFFDETAGDFATGDFRSDETAAFDATGDFESQETGAFD");
    }
}
