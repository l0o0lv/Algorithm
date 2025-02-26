import java.util.*;
import java.io.*;

class Solution {
    static int[] price;
    static int[] plan;
    static int answer;
    
    static void dfs(int month, int sum){
        if(month > 12){
            answer = Math.min(answer,sum);
            return;
        }

        if(plan[month] == 0){
            dfs(month + 1, sum);
        } else{
            dfs(month + 1, sum + (plan[month] * price[0]));
            dfs(month + 1, sum + price[1]);
            dfs(month + 3, sum + price[2]);
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc <= testCase ; tc++){
            price = new int[4];
            plan = new int[13];

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < 4 ; i++){
                price[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i <= 12 ; i++){
                plan[i] = Integer.parseInt(st.nextToken());
            }

            answer = price[3];

            dfs(1,0);
            System.out.println("#" + tc + " " + answer);
        }
    }
}