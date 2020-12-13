package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotInAscendingOrder {
    public static void main(String[] args) {

        count(Arrays.asList(1,1,3,4,1));
        count(Arrays.asList(1,1,3,4,1,1));
        count(Arrays.asList(4,3,2,1));
        count(Arrays.asList(1,2,3,4));
        count(Arrays.asList(1,6,3,4,2));
        count(Arrays.asList(1,1,3,1,2));
        count(Arrays.asList(1,2,3,4,3,2,1));

    }
    public static int count(List<Integer>height){
        //find the list of numbers which are breaking the ascending order
        if(height.get(0)>height.get(1)){
            System.out.println(height);
            return height.size();
        }
        List<Integer> count= new ArrayList<>();
        boolean smallestFound = false;
        for(int i = 0; i<height.size()-1; i++) {
            if (height.get(i) > height.get(i + 1)) {
                for (int j = 0; j <= i + 1; j++) {
                    if (height.get(j) > height.get(i + 1)) {
                        while(j <= height.size()-1){
                            count.add(height.get(j));
                            j++;
                        }
                        break;
                    }
                }
                smallestFound = true;
            }
            if(smallestFound){
                break;
            }
        }
//        count =count.stream().distinct().collect(Collectors.toList());
        System.out.println(count);
        return count.size();
    }
}
