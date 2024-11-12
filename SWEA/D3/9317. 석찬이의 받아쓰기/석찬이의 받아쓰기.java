import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= testCase ; i++){
            System.out.print("#" + i + " ");

            int count = Integer.parseInt(br.readLine());
            String answer = br.readLine();
            String myAnswer = br.readLine();

            for(int j = 0 ; j < answer.length(); j++){
                int answerAsci = answer.charAt(j);
                int myAnswerAsci = myAnswer.charAt(j);

                if(answerAsci != myAnswerAsci)
                    count--;
            }

            System.out.println(count);
        }

    }
}