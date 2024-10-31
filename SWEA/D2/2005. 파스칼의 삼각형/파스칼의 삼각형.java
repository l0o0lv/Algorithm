import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= testCase ; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            arr[0][0] = 1;
            
            for(int j = 1 ; j < N ; j++){
                for(int k = 0 ; k < N ; k++){
                    if(k == 0)
                        arr[j][k] = 1;
                    else{
                        arr[j][k] = arr[j-1][k-1] + arr[j-1][k];
                    }
                }
            }

            System.out.println("#" + i);
            for(int j = 0 ; j < N ; j++){
                System.out.print(arr[j][0]);
                for(int k = 1 ; k < N ; k++){
                    if(arr[j][k] != 0)
                        System.out.print(" " + arr[j][k]);
                }
                System.out.println("");
            }
        }
    }
}