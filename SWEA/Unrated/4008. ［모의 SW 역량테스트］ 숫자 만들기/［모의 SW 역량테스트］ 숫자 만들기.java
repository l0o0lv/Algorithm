import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static int[] num;
    static int[] operator;
    static int min, max;
    
    static void backtracking(int sum, int depth){
        if(depth == N - 1){
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0 ; i < 4 ; i++){
            if(operator[i] > 0){
                operator[i]--;
                if(i == 0){
                    backtracking(sum + num[depth + 1], depth + 1);
                } else if(i == 1){
                    backtracking(sum - num[depth + 1], depth + 1);
                } else if(i == 2){
                    backtracking(sum * num[depth + 1], depth + 1);
                } else if(i == 3){
                    backtracking(sum / num[depth + 1], depth + 1);
                }
                operator[i]++;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc <= testCase ; tc++){
            N = Integer.parseInt(br.readLine());

            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            num = new int[N];
            operator = new int[4];

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < 4; i ++){
                operator[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            backtracking(num[0], 0);

            System.out.println("#" + tc + " " + (max-min));
        }
        
    }
}