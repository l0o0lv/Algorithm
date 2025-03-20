import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;
    static int[] input;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        arr = new int[12];
        
        for(int i = 0 ; i < N ; i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i = 4 ; i <= 11 ; i++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }

        for(int i = 0 ; i < N ; i++){
            System.out.println(arr[input[i]]);
        }
    }
}