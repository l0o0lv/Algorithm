import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());
        int arr[][] = new int[size][size];
        
        for(int i = 0 ; i < size ; i++){
            st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < size ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                }
        }

        int prefixArr[][] = new int[size+1][size+1];

        for(int i = 1 ; i < prefixArr.length ; i++){
            for(int j = 1 ; j < prefixArr.length ; j++){
                prefixArr[i][j] = prefixArr[i][j-1] + arr[i-1][j-1];
            }
        }

        for(int tryCount = 0 ; tryCount < question ; tryCount ++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int sum = 0;

            for(int i = x1 ; i <= x2 ; i++){
                sum += prefixArr[i][y2] - prefixArr[i][y1-1];
            }
            System.out.println(sum);
        }
    }
}