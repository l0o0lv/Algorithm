import java.util.*;
import java.io.*;

class Solution {
    static int[] arr;
    static int testCase;
    static int changeCount;
    static int maxPrice;

    static void dfs(int start, int count){
        if(count == changeCount){
            StringBuilder sb = new StringBuilder();
            for(int i : arr){
                sb.append(i);
            }
            maxPrice = Math.max(maxPrice, Integer.parseInt(sb.toString()));
            return;
        }

        for(int i = start ; i < arr.length; i++){
            for(int j = i + 1 ; j <arr.length ; j++){
                swap(i,j);
                dfs(i, count + 1);
                swap(i,j);
            }
        }
    }

    static void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        testCase = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc <= testCase ; tc++){
            st = new StringTokenizer(br.readLine());

            String num = st.nextToken();

            changeCount = Integer.parseInt(st.nextToken());
            maxPrice = Integer.MIN_VALUE;

            arr = new int[num.length()];

            for(int i = 0 ; i < arr.length ; i++){
                arr[i] = num.charAt(i) - '0';
            }
            dfs(0,0);

            bw.write("#" + tc + " " + maxPrice + "\n");

            bw.flush();
        }
    }
}