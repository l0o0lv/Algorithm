import java.util.*;
import java.io.*;

class Solution {
    static int testCase;
    static int N;
    static int tree[];
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        testCase = Integer.parseInt(br.readLine());
        
        for(int tc = 1 ; tc <= testCase ; tc++){
            N = Integer.parseInt(br.readLine());

            tree = new int[N];
            int max = 0;
            int answer = 0;
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++){
                tree[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, tree[i]);
            }

            int even = 0;
            int odd = 0;
            for(int i = 0 ; i < N; i++){
                int diff = max - tree[i];

                if(diff == 0) continue;

                even += diff /2;
                odd += diff % 2;
            }

            if(even > odd){
                while(Math.abs(even - odd) > 1){
                    even--;
                    odd += 2;
                }
            }

            if(even > odd){
                answer = even * 2;
            }
            else if(odd > even){
                answer = (odd * 2) - 1; 
            }
            else{
                answer = odd + even;
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}