import java.util.*;
import java.io.*;

class Main {

    static boolean visited[];
    static int[][] Graph;
    static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Graph[u][v] = 1;
            Graph[v][u] = 1;
        }

        for(int i = 1; i<=N ; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int node){
        visited[node] = true;

        for(int next = 1 ; next < Graph.length ; next++){
            if(!visited[next] && Graph[node][next] == 1){
                dfs(next);
            }
        }
    }
}