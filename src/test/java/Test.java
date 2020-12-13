import string.MaxDiff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    int a = 10;
    public int b = 20;

    public void method1() {
        int c = a + b;
    }

    private int method2() {
        return a + b;
    }

    public int method3() {
        return 10;
    }

    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public static void main(String[] args) {
//    int a =fib1(5);
//    System.out.println(a);

//Fibonacci f = new Fibonacci();
//    int n = 40;
//    f._initialize();

//    System.out.println("Fibonacci number is" + " " + f.fib(n));

        System.out.println(validBrackets("{{{[[(())]]}}}"));
        System.out.println(validBrackets("{{{[[(()]]}}}"));
        System.out.println(validBrackets("{{{[[(())]]}}"));
        System.out.println(validBrackets("{{{[[(())]}}}"));
        System.out.println(validBrackets("[]"));
        System.out.println(validBrackets("["));
        System.out.println(validBrackets("[[()]]"));
        System.out.println(validBrackets("[[{}]]"));
        System.out.println(validBrackets("([[{}]])"));
        //"{[}}}}}"

        MaxDiff maxDiff = new MaxDiff();
//        System.out.println(maxDiff.maxDiff(Arrays.asList(7, 1, 2, 5)));
//        System.out.println(maxDiff.maxDiff(Arrays.asList(2, 3, 1, 0, 2, 4, 8, 1)));
//        System.out.println(maxDiff.maxDiff(Arrays.asList(7, 5, 3, 1)));

    }




    public static boolean validBrackets(String brackets) {
        if (brackets == null) {
            return false;
        }

        int length = brackets.length();

        if (length % 2 != 0) {
            return false;
        }

        List listOfBrackets = Arrays.asList(brackets.split(""));
        List<Boolean> truce = new ArrayList();
        int evenIndex = length/2;

        for(int i = 0; i < evenIndex; i++){
            if(listOfBrackets.get(i).equals("(")){
                if(listOfBrackets.get(evenIndex*2 - (i+1)).equals(")")){
                    truce.add(true);
                } else {
                    return false;
                }
            } else if(listOfBrackets.get(i).equals("{")){
                if(listOfBrackets.get(evenIndex*2 - (i+1)).equals("}")){
                    truce.add(true);
                } else {
                    return false;
                }
            } else if(listOfBrackets.get(i).equals("[")){
                if(listOfBrackets.get(evenIndex*2 - (i+1)).equals("]")){
                    truce.add(true);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        if(isAllTrue(truce)){
            return true;
        }
        return false;
    }

    public static boolean isAllTrue(List<Boolean> lists){
        for(Boolean value : lists){
            if(value == false){
                return false;
            }
        }
        return true;
    }

}
