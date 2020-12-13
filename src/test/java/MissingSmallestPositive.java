import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MissingSmallestPositive {


    public static void main(String[]args){
        int[] A = {1, 3, 6, 4, 1, 2};
        int[] B = {1, 2, 3};

System.out.println(method(B));
    }


    public static int method(int[] A){
        int temp;
        for (int i = 0; i < A.length; i++)
        {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
        int smallest = A[0];
        for(int i=0; i<A.length; i++){
            if(A[i]<=0){
                return 1;
            } else if(A[i]==1){
                smallest = A[i];
                break;
            } else {
                return 1;
            }
        }

        for(int i=smallest + 1; i<A[A.length-1]+2; i++) {
            boolean found = false;
            for (int j = 0; j < A.length; j++) {
                if (A[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }
        }

        return 0;
    }


}
