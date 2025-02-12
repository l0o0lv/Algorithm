import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] firstPrime = {2,3,5,7};
        for(int i = 0 ; i < firstPrime.length ; i++){
            DFS(firstPrime[i], N - 1);
        }
    }

    static void DFS(int num , int N){
        if(N == 0){
            System.out.println(num);
            return;
        }

        for(int i = 1 ; i < 10 ; i++){
            int nextNum = 10 * num + i;
            if(N > 0 && isPrime(nextNum)){
                DFS(nextNum,N-1);
            }
        }
    }

    static boolean isPrime(int num){
        if(num < 2){
            return false;
        }

        for(int i = 2 ; i*i <= num ; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}