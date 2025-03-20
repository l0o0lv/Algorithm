import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr = new int[1000001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr[1] = 0;

        for(int i = 2 ; i <= N ; i++){
            arr[i] = arr[i-1] + 1;
            if(i % 3 == 0) arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            if(i % 2 == 0) arr[i] = Math.min(arr[i], arr[i / 2] + 1);
        }
        System.out.println(arr[N]);
    }
}