import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m;
    static boolean[] visited;
    static int[] arr;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        arr = new int[m];
        
        dfs(1, 0);
    }

    static void dfs(int num, int cnt){
        if(cnt == m){
            for(int i = 0 ; i < m ; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = num ; i <= n ; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[cnt] = i;
                dfs(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}