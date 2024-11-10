import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 1 ; i <= testCase ; i ++){
            System.out.print("#" + i + " ");
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a >= 10 || b >= 10){
                System.out.println("-1");
                continue;
            }

            System.out.println(a * b);
            
        }
        
    }
}