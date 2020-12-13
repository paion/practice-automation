import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class Practice2 {

    double i;

    public double getI() {
        return i;
    }

    public static void main(String[]args) {
       String a = "RawINpte$$##Resdf$$##IFLjfd";

        String[] spliters = a.split("##");
        for(String s: spliters){
            if( s.contains("$$") && isDouble(s.replace("$$", ""))){
                System.out.println("double " + s);
            } else if(!s.contains("$$") &&  isInteger(s)){
                System.out.println("integer " + s);
            } else {
                System.out.println("string " + s);
            }
        }

    }

    public static boolean isDouble(String yes){
        try {
            Double.parseDouble(yes);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isInteger(String yes){
        try {
            Integer.parseInt(yes);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

}
