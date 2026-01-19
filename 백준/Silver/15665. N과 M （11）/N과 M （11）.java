import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m;
    static int[] arr;
    static int[] nums;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        arr = new int[m];
        visited = new boolean[n];
        
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n ; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        
        dfs(0);
        bw.flush();
        bw.close();
    }

    static void dfs(int cnt) throws Exception{
        if(cnt == m){
            for(int num : arr) bw.write(num + " ");
            bw.write("\n");
            return;
        }

        int lastUsed = -1;
        for(int i = 0; i < n ; i++){
            if(lastUsed == nums[i]) continue;

            arr[cnt] = nums[i];
            lastUsed = nums[i];
            dfs(cnt + 1);
        }
    }
}