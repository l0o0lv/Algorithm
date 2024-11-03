import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 1 ; i <= testCase ; i++){
            st = new StringTokenizer(br.readLine());

            int minExcerciseTime = Integer.parseInt(st.nextToken());
            int maxExcerciseTime = Integer.parseInt(st.nextToken());
            int takeExerciseTime = Integer.parseInt(st.nextToken());

            if(takeExerciseTime > minExcerciseTime && takeExerciseTime < maxExcerciseTime){
                System.out.println("#" + i + " 0");
                continue;
            }
            if(takeExerciseTime < minExcerciseTime){
                System.out.println("#" + i + " " + (minExcerciseTime-takeExerciseTime));
                continue;
            }
            if(takeExerciseTime > maxExcerciseTime){
                System.out.println("#" + i + " -1");
                continue;
            }
        }
    }
}