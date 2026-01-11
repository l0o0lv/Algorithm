import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    static int N, M;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth){
        if(depth == M){
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return; // return 반드시 필요
        }

        for(int i = 0 ; i < N ; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}