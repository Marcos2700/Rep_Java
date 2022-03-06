
/**
 * Write a description of class Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
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
    public void testHowMany(){
        int test1, test2, test3;
        test1 = howMany("as","as gyu as das jas");
        System.out.println("test1: "+test1);
        test2 = howMany("sus","sus manos estan en sus pies");
        System.out.println("test2: "+test2);
        test3 = howMany("no","onoonoonoononono");
        System.out.println("test3: "+test3);
    }
}
