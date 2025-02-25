import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        boolean isPrime[] = new boolean[10_000_001];
        Arrays.fill(isPrime, 2, 10_000_001, true);

        for(int i = 2 ; i < isPrime.length ; i++){
            if(isPrime[i]){
                list.add(i);
                for(long j = (long) i * i ; j < isPrime.length ; j+=i){
                    isPrime[(int)j] = false;
                }
            }
        }

        for(int num : list){
            String numToText = Integer.toString(num);
            String reverseNum = new StringBuilder(numToText).reverse().toString();

            if(num >= N && numToText.equals(reverseNum)){
                System.out.println(num);
                return;
            }
        }
    }
}