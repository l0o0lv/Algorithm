import java.util.*;
import java.io.*;

class Solution {
    static int N, L;
    static int[][] ingredient;
    static int maxScore;

    static void dfs(int index, int nowScore, int totalCal){
        if(totalCal > L) return;
        
        maxScore = Math.max(maxScore, nowScore);

        for(int i = index ; i < N ; i++){
                dfs(i + 1, nowScore + ingredient[i][0], totalCal + ingredient[i][1]);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= testCase ; tc++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            ingredient = new int[N][2];
            maxScore = 0;

            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                ingredient[i][0] = Integer.parseInt(st.nextToken());
                ingredient[i][1] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, 0);
                
            System.out.println("#" + tc + " " + maxScore);
        }
    }
}