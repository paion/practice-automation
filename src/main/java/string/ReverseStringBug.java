package string;

import java.util.Objects;

public class ReverseStringBug {

    public static void main(String[]args){
        if((!Objects.equals("a", "b") && !Objects.equals("a", "c"))){
            System.out.println("this is if");
        } else {
            System.out.println("this is else");
        }
    }

}
