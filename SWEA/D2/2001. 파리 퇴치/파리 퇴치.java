import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 1 ; i <= testCase ; i++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            int max = 0;
            
            for(int j = 0 ; j < N ; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < N ; k++)
                    arr[j][k] = Integer.parseInt(st.nextToken());
            }

            for(int j = M - 1 ; j < N ; j++){
                for(int k = M - 1 ; k < N ; k++){
                    int deadFly = 0;
                    for(int l = j - (M-1) ; l <= j ; l++)
                        for(int m = k - (M-1) ; m <= k ; m++)
                            deadFly += arr[l][m];
                    if(max < deadFly)
                        max = deadFly;
                }
            }
            System.out.println("#" + i + " " + max);
        }
    }
}