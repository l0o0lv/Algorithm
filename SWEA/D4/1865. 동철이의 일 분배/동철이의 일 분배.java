import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static double[][] probability;
    static boolean[] visited;
    static double maxProbability;

    static void dfs(int worker, double nowProbability){
        if(worker == N){
            maxProbability = Math.max(maxProbability, nowProbability);
            return;
        }

        if(nowProbability <= maxProbability){
            return;
        }

        for(int job = 0 ; job < N ; job++){
            if(!visited[job]){
                visited[job] = true;
                dfs(worker + 1, nowProbability * probability[worker][job]);
                visited[job] = false;
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc <= testCase ; tc++){
            N = Integer.parseInt(br.readLine());
            probability = new double[N][N];
            visited = new boolean[N];
            maxProbability = 0;

            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N ; j++){
                    probability[i][j] = Double.parseDouble(st.nextToken()) / 100;
                }
            }

            dfs(0,1.0);

            System.out.printf("#%d %.6f\n", tc, maxProbability * 100);
        }
    }
}