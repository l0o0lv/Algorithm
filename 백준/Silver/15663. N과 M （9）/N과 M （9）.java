import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m;
    static int[] arr, num;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        arr = new int[m];
        visited = new boolean[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(num);
        
        dfs(0);

        bw.flush();
        bw.close();
    }

    static void dfs(int cnt) throws Exception{
        if(cnt == m){
            for(int i = 0 ; i < m ; i++){
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        int lastNum = 0;
        for(int i = 0 ; i < n ; i++){
            if(!visited[i] && lastNum != num[i]){
                visited[i] = true;
                arr[cnt] = num[i];
                lastNum = num[i];
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }
}