package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReverseString {
    public static void main(String[] args) {
        reverse("bangladesh");
    }
    public static void reverse(String s){
        char[] a = s.toCharArray();
        for(int i=a.length-1;i>=0;i--){
            System.out.print(a[i]);
        }

    }
}
