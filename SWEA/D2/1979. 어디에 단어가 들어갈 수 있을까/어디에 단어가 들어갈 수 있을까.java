import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 1 ; i <= testCase ; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int answer = 0;
            int arr[][] = new int[N][N];
            
            for(int j = 0 ; j < arr.length ; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < arr.length ; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

        for(int j  = 0 ; j < N ; j++){
            int count = 0;
            for(int k = 0 ; k < N ; k++){
                if(arr[j][k] == 0){
                    if(count == K)
                        answer++;
                    count = 0;
                }
                else{
                    count++;
                }
            }
                if(count == K)
                    answer++;
            
        }
        for(int j  = 0 ; j < N ; j++){
            int count = 0;
            for(int k = 0 ; k < N ; k++){
                if(arr[k][j] == 0){
                    if(count == K)
                        answer++;
                    count = 0;
                }
                else{
                    count++;
                }
            }
                if(count == K)
                    answer++;
            
        }
            System.out.println("#" + i + " " + answer);
	}
}
}