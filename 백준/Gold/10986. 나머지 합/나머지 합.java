import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long prefixArr[] = new long[N];
        long numberCountArr[] = new long[M];
        long count = 0;
        st = new StringTokenizer(br.readLine());
        prefixArr[0] = Integer.parseInt(st.nextToken());
        
        for(int i = 1 ; i < prefixArr.length ; i++){
            prefixArr[i] = Integer.parseInt(st.nextToken()) + prefixArr[i-1];
        }

        for(int i = 0 ; i < prefixArr.length ; i++){
            int remainder = (int)(prefixArr[i] % M);

            if(remainder == 0)
                count++;

            numberCountArr[remainder]++;
        }

        for(int i = 0 ; i < numberCountArr.length ; i++){
            long numberCount = numberCountArr[i];
            if(numberCount > 1){
                count += ((numberCount * (numberCount -1)) / 2);
            }
        }
        System.out.println(count);
        }
    }