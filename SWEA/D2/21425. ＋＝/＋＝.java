import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 1 ; i <= testCase ; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int count = 0;

            while(true){
                if(x > y){
                    y+=x;
                    count++;
                }
                else{
                    x+=y;
                    count++;
                }
                if(x>N || y>N)
                    break;
            }

            System.out.println(count);
        }
    }
}