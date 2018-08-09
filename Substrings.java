import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Substrings {

    static String acidNaming(String acid_name) {
        int aLength = acid_name.length();
        String lastTwoChars = aLength > 2 ? acid_name.substring(aLength - 2) : acid_name;
        if(lastTwoChars.equals("ic")){
        	System.out.println(acid_name.substring(0,5));
            if(aLength >= 5 &&  acid_name.substring(0,5).equals("hydro")){
               return ("non-metal acid") ;
            }
           return ("polyatomic acid") ;
        }
        return ("not an acid");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String acid_name = in.next();
            String result = acidNaming(acid_name);
            System.out.println(result);
        }
        in.close();
    }
}


