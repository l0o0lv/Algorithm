import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int count = 1;
        int arr[] = new int[number];
        int start = 0;
        int end = 0;
        
        for(int i = 0 ; i < number ; i++){
            arr[i] = (i+1);
        }

        int prefixSum = arr[0];

        while(start != number-1 && end != number-1){
            // System.out.println("start = " + start +", end = " + end + ", sum = " + prefixSum + ", count = " + count);

            if(prefixSum < number)
                prefixSum += arr[++end];
            else if(prefixSum >= number)
                prefixSum -= arr[start++];
            
            if(prefixSum == number)
                count++;          
        }

        System.out.println(count);
    }
}