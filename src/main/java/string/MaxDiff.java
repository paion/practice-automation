package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxDiff {
    static List a = Arrays.asList(7, 1, 2, 5);
    public static void main(String[]args){
       System.out.println(maxDiff(a));
    }

    public static int maxDiff(List<Integer> nums) {
        List<Integer> diff = new ArrayList<>();
        boolean isSmallerLeftFound = false;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if (nums.get(i) < nums.get(j)) {
                    diff.add(nums.get(j) - nums.get(i));
                    isSmallerLeftFound = true;
                }
            }
        }
        if(!isSmallerLeftFound){
             return -1;
        }
        return Collections.max(diff);
    }


}
