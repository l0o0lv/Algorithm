import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] arr, lotto;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            if(k == 0 ) break;
            
            lotto = new int[k];
            arr = new int[6];
            
            for(int i = 0 ; i < k ; i++) lotto[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(lotto);
            dfs(0, 0);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int index, int cnt) throws Exception{
        if(cnt == 6){
            for(int num : arr) bw.write(num + " ");
            bw.write("\n");
            return;
        }

        for(int i = index ; i < lotto.length ; i++){
            arr[cnt] = lotto[i];
            dfs(i + 1 , cnt + 1);
        }
    }
}