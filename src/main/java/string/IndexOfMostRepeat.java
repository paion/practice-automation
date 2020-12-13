package string;

import java.util.HashMap;
import java.util.Map;

/*
* //Given an array of integers nums sorted in ascending order, find the starting and ending index of the most repeating number.

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [0,1,2,2,3,3,3]
Output: [4,6]

Example 2:

Input: nums = [0,1,2]
Output: [-1,-1]

Example 3:

Input: nums = [0,1,2,2,3,3]
Output: [2,3] or [4,5]
*/
public class IndexOfMostRepeat {

    public static void main(String[]args){
        int[] nums = {0,1,2,2,3,3,3,4,5,6,6,7,8,9,9,9,9};
        startingAndEndingOfMostRepeat(nums);
    }

    public static int[] startingAndEndingOfMostRepeat(int[] nums) {
        // your code goes here
        HashMap<Integer, Integer> keyValus = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (keyValus.get(nums[i]) != null) {
                keyValus.put(nums[i], keyValus.get(nums[i]) + 1);
            } else {
                keyValus.put(nums[i], 1);
            }
        }

        int highestValue = 0;
        int highestKey = 0;
        for ( Map.Entry<Integer, Integer> values : keyValus.entrySet()) {
            if (values.getValue() > highestValue) {
                highestValue = values.getValue();
                highestKey = values.getKey();
            }
        }

        int starting = -1;
        int ending = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == highestKey) {
                starting = j;
                ending = starting + highestValue -1;
                break;
            }
        }

        int [] result = {starting, ending};
        System.out.println(starting + " , " + ending);
        return result;
    }

}
