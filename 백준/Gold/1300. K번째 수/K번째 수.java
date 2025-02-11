import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long left = 1;
        long right = N * N;
        long answer = 0;

        while(left <= right){
            long mid = (left + right) / 2;

            long count = 0;

            for(int i = 1; i <= N ; i++){
                count += Math.min(mid / i , N);
            }

            if(count >= k){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}