import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] stair;
    static int[] dp;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stair = new int[301];
        dp = new int[301];

        for(int i = 0 ; i < N ; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stair[0];
        dp[1] = stair[0] + stair[1];
        dp[2] = Math.max(stair[0], stair[1]) + stair[2];

        for(int i = 3 ; i < N ; i++){
            dp[i] = Math.max(dp[i-3] + stair[i-1], dp[i-2]) + stair[i];
        }

        System.out.println(dp[N-1]);
    }
}