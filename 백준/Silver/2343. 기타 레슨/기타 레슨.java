import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int left = 0;
        int right = 0;

        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left,arr[i]);
            right += arr[i];
        }

        while(left <= right){
            int mid = (left + right) / 2;

            int count = 1;
            int sum = 0;

            for(int i = 0 ; i < N ; i++){
                if(sum + arr[i] > mid){
                    count++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }
            }

            if(count > M){ //블루레이 개수가 많다면
                left = mid + 1; //블루레이 사이즈가 작은 것, 크기를 늘려준다.
            } else{ //적거나 같다면
                right = mid - 1; //블루레이 사이즈가 큰 것, 크기를 줄여준다.
                //else if(count < M) 을 하면 안됨.
                //count == M 인 경우에도 해줘야 한다.
                //더 작은 크기로 가능할지 확인해야 하기 때문
            }
        }
        System.out.println(left);
    }
}