
/**
 * Write a description of class Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int sizeSA = stringa.length();
        int start = stringb.indexOf(stringa);
        int stop = stringb.indexOf(stringa, start + sizeSA);
        int position = start, cont = 0;
        while(position != -1){
            cont++;
            position = stringb.indexOf(stringa, position+sizeSA);
        }
        if (cont > 1){
            return true;
        }
        else{
            return false;
        }
    }
    public void testing(){
        boolean test1, test2, test3;
        String  test4, test5, test6;
        test1 = twoOccurrences("o","loco");
        System.out.println(test1);
        test2 = twoOccurrences("a","laco");
        System.out.println(test2);
        test3 = twoOccurrences("no","nosotros no vamos");
        System.out.println(test3);
        test4 = lastPart("l","loco");
        System.out.println(test4);
        test5 = lastPart("ajo","duerme");
        System.out.println(test5);
        test6 = lastPart("nos","nos fuimos el dia anterior");
        System.out.println(test6);
    }
    public String lastPart(String stringa, String stringb){
        int sizeSA = stringa.length();
        int sizeSB = stringb.length();
        int start = stringb.indexOf(stringa);
        int stop = stringb.indexOf(stringa, sizeSB);
        if (start == -1){
            return stringb;
        }
        else{
            return stringb.substring(start + sizeSA);
        }
    }
}
