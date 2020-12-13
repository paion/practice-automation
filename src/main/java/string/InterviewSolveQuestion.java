package string;


import java.util.Arrays;

public class InterviewSolveQuestion {

    //
    /*
    * method where it takes a random integer and sort them without any sort method
    *
    *
    *
    * */

    public static void main(String []args){
        int [] list = {2,3,5,9,1,4,7};
        sortArrayList(list);
    }

    public static int[] sortArrayList(int[] arrayList){
        if(arrayList.length == 0){
            return arrayList;
        }
        int length = arrayList.length;
        for(int i=0; i< length; i++ ){
            int temp = arrayList[i];
            for(int j=i+1; j< length; j++){
                if(arrayList[i]> arrayList[j]){
                    temp = arrayList[i];
                    arrayList[i]= arrayList[j];
                    arrayList[j]= temp;
                }
            }
        }
        System.out.println(Arrays.toString(arrayList));
        return arrayList;

    }

   
}
