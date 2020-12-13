package string;

import java.util.ArrayList;
import java.util.HashMap;

public class Ave {


    public Ave(){
        Fibonacci fibonacci = new Fibonacci();

    }

    public static void main(String[]args){
        String[][] scoreslist = {{"Bobby", "87"}, {"Charles", "100"}, {"Eric", "64"}, {"Charles", "22"}};
  ave(scoreslist);

    }

    public static Integer ave(String[][] scoreslist){
        HashMap<String, ArrayList<Integer>> students = new HashMap<>();
int a = Integer.MAX_VALUE;
int b= Integer.MAX_VALUE;

        for(String[] scoreRow : scoreslist){
            String student = scoreRow[0];
            Integer score = Integer.parseInt(scoreRow[1]);
            ArrayList<Integer> scores = students.get(student);
            if(scores == null){
                scores = new ArrayList<>();
                scores.add(score);
                students.put(student, scores);
            }else {
                scores.add(score);
            }
        }

        double max = 0.0;
        for(ArrayList<Integer> studentscores: students.values()){
            Integer sum = 0;
            for(Integer i: studentscores){
                sum +=i;
            }
            double aver = sum/studentscores.size();
            max  = Math.max(max, aver);
        }
        return (int)Math.floor(max);
    }
}
