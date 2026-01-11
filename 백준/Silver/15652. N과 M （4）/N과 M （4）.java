import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m;
    static boolean[] visited;
    static int[] arr;
    static BufferedWriter bw;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        arr = new int[m];
        
        dfs(1, 0);

        bw.flush();
        bw.close();
    }

    static void dfs(int num, int cnt) throws Exception{
        if(cnt == m){
            for(int i = 0 ; i < m ; i++){
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = num ; i <= n ; i++){
            arr[cnt] = i;
            dfs(i, cnt + 1);
        }
    }
}