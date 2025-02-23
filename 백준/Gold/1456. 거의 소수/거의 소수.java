import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long count = 0;
        boolean[] isPrime = new boolean[(int)Math.sqrt(b) + 1];

        for(int i = 2 ; i < isPrime.length ; i ++){
            isPrime[i] = true;
        }
        
        for(int i = 2 ; i * i < isPrime.length ; i++){
            if(isPrime[i]){
                for(int j = i * i ; j < isPrime.length ; j+= i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i = 2 ; i < isPrime.length ; i++){
            if(isPrime[i]){
                long index = (long) i * i;
                while(index <= b){
                    if(index >= a) count++;
                    if(index > b / i) break;
                    index *= i;
                }
            }
        }
        System.out.println(count);
    }
}