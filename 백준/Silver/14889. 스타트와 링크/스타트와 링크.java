import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int answer = Integer.MAX_VALUE;
    static int n;
    static int[][] points;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        points = new int[n][n];
        visited = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                points[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int index, int cnt){
        if(cnt == n / 2){
            int start = 0;
            int link = 0;
            for(int i = 0 ; i < n - 1 ; i++){
                if(visited[i]){
                    for(int j = i + 1 ; j < n ; j++){
                        if(visited[j]) start += (points[i][j] + points[j][i]);
                    }
                }
                else if(!visited[i]){
                    for(int j = i + 1 ; j < n ;j++){
                        if(!visited[j]) link += (points[i][j] + points[j][i]);
                    }
                }
            }

            answer = Math.min(answer, Math.abs(start - link));
            return;
        }

        for(int i = index ; i < n ; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}