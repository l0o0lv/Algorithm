import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static boolean[] isPrime;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isPrime = new boolean[M+1];

        for(int i = 2 ; i < isPrime.length ; i++){
            isPrime[i] = true;
        }
        
        for(int i = 2 ; i <= Math.sqrt(M) ; i++){
            if(isPrime[i]){
                for(int j = i * i ; j <= M ; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i = N ; i < isPrime.length ; i++){
            if(isPrime[i]){
                System.out.println(i);
            }
        }
    }
}