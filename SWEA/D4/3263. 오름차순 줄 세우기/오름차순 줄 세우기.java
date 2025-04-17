import java.util.*;
import java.io.*;

class Solution {
    static int testCase;
    static int N;
    static int[] child;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        testCase = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc <= testCase ; tc++){
            N = Integer.parseInt(br.readLine());
            child = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++){
                child[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[N + 1];
            int seq = 0;
            
            for(int i = 0 ; i < N ; i++){
                dp[child[i]] = dp[child[i] - 1] + 1;
                seq = Math.max(seq, dp[child[i]]);
            }

            System.out.println("#" + tc + " " + (N - seq));
        }
        
    }
}