import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        int arr[] = new int[N];
        int start = 0;
        int end = 1;
        
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int prefixSum = arr[0];

        while(start != N-1){
            if(arr[start] + arr[end++] == M)
                count++;
            if(end == N){
                start++;
                end = start+1;
            }       
        }

        System.out.println(count);
    }
}