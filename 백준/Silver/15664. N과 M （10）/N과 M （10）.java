import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] arr, nums;
    static boolean[] visited;
    static int n, m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        nums = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        
        dfs(0, 0);

        bw.flush();
        bw.close();
    }

    static void dfs(int index, int cnt) throws Exception{
        if(cnt == m){
            for(int num : arr){
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        int lastUse = 0;
        for(int i = index ; i < n ; i++){
            if(!visited[i] && lastUse != nums[i]){
                visited[i] = true;
                lastUse = nums[i];
                arr[cnt] = nums[i];
                dfs(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}