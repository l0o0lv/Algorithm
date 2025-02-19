import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //금액 개수
        int K = Integer.parseInt(st.nextToken()); // K원

        int[] value = new int[N];
        int answer = 0;
        
        for(int i  = 0 ; i < N ; i++){
            value[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N - 1; i >= 0 ; i--){
            if(value[i] > K){
                continue;
            }

            answer += (K / value[i]);
            K = (K % value[i]);

            if(K == 0){
                break;
            }
        }

        System.out.println(answer);
    }
}