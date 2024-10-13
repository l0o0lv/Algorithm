import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= num ; i++){
            int answer = 0;
            int a = Integer.parseInt(br.readLine());
            for(int j = 1 ; j <= a; j++){
                if(j % 2 == 0)
                    answer -= j;
                else if(j % 2 == 1)
                    answer += j;
            }
            System.out.println("#" + i + " " + answer);
        }
    }
}