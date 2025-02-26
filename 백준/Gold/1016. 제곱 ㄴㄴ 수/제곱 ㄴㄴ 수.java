import java.util.*;
import java.io.*;

class Main {
    static boolean[] isJegopNoNo;

    static int countIsJegopNoNo(long min, long max){
        for(long i = 2 ; i * i <= max ; i++){
            long square = i * i;
            long start = (min % square == 0) ? min : (min / square +1) * square;

            for(long j = start ; j <= max ; j+=square){
                isJegopNoNo[(int)(j - min)] = false;
            }
        }
        int count = 0;

        for(int i = 0 ; i < isJegopNoNo.length ; i++){
            if(isJegopNoNo[i]) count++;
        }

        return count;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        isJegopNoNo = new boolean[(int)(max - min + 1)];
        Arrays.fill(isJegopNoNo,true);

        int count = countIsJegopNoNo(min, max);

        System.out.println(count);
        
    }
}