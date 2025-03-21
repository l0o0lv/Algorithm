import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] rgb;
    static int[][] dp;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        rgb = new int[N][N];
        dp = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; j++){
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < N ; i++){
            dp[0][i] = rgb[0][i];
        }

        for(int i = 1 ; i < N ; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
        }

        System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
    }
}