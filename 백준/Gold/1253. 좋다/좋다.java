import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        long arr[] = new long[N];
        
        for(int i = 0 ; i < N ; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(arr);

        for(int k = 0 ; k < N ; k++){
            long isGood = arr[k];
            int start = 0;
            int end = N-1;

            while(start != end){
                if(arr[start] + arr[end] == isGood){
                    if(start != k && end != k){
                    count++;
                    break;
                    }
                    else if(start == k){
                        start++;
                    }
                    else if(end == k){
                        end--;
                    }
                }
                else if(arr[start] + arr[end] < isGood){
                    start++;
                }
                else if(arr[start] + arr[end] > isGood){
                    end--;
                }
            }
        }
        System.out.println(count);
    }
}