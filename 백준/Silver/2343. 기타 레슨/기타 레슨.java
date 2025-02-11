import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] lesson = new int[N];
        int right = 0;
        int left = 0;
        
        for(int i = 0 ; i < N ; i++){
            lesson[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left,lesson[i]);
            right += lesson[i];
        }

        while(left <= right){
            int mid = (right + left) /2;

            int count = BSearch(mid,lesson);
            
            if(count > M){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);   
    }

    static int BSearch(int mid, int lesson[]){
        int sum = 0;
        int count = 1;

        for(int i = 0 ; i < lesson.length ; i++){
            if(sum + lesson[i] > mid){
                count++;
                sum = lesson[i];
            } else {
                sum += lesson[i];
            }
        }
        return count;
    }
}
