import java.util.*;
import java.io.*;

class Solution {
    static int[][] food;
    static boolean[] visited;
    static int N, min, limit;

    static void dfs(int count, int index){
        if(count == limit){
            check();
            return;
        }

        for(int i = index ; i < N; i++){
            visited[i] = true;
            dfs(count + 1, i + 1);
            visited[i] = false;
        }
    }

    static void check(){
        int a = 0;
        int b = 0;
        int result = 0;

        for(int i = 0 ; i < N - 1 ; i++){
            for(int j = i + 1 ; j < N ; j++){
                if(visited[i] && visited[j]){
                    a += food[i][j] + food[j][i];
                }
                else if(!visited[i] && !visited[j]){
                    b += food[i][j] + food[j][i];
                }
            }
        }

        result = Math.abs(a - b);
        min = Math.min(min, result);
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc <= testCase ; tc++){
            N = Integer.parseInt(br.readLine());

            limit = N / 2;
            food = new int[N][N];
            visited = new boolean[N];
            min = Integer.MAX_VALUE;

            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ;  j <N ; j++){
                    food[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0,0);

            System.out.println("#" + tc + " " + min);
        }
    }
}