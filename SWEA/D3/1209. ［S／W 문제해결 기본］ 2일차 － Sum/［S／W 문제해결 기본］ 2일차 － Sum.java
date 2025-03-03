import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int tc = 1; tc <= 10 ; tc++){
            int testCase = Integer.parseInt(br.readLine());

            int[][] arr = new int[100][100];

            for(int i = 0 ; i < 100 ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < 100 ; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for(int i = 0 ; i < 100 ; i++){
                int sum1 = 0;
                int sum2 = 0;
                for(int j = 0 ; j < 100; j++){
                    sum1+= arr[i][j];
                    sum2+= arr[j][i];
                }
                sum2 = Math.max(sum1,sum2);
                answer = Math.max(answer, sum2);
            }

            int sum3 = 0;
            for(int i = 0 ; i < 100 ; i++){
                sum3+= arr[i][i];
            }

            int sum4 = 0;
            for(int i = 99 ; i >= 0 ; i--){
                sum4 += arr[i][i];
            }

            sum4 = Math.max(sum3,sum4);

            answer = Math.max(answer,sum4);

            System.out.println("#" + tc + " " + answer);
        }
    }
}