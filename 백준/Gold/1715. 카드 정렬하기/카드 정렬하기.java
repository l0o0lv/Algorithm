import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 카드 묶음 개수
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < N ; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        while(pq.size() > 1){
            int sum = pq.poll() + pq.poll();
            answer += sum;
            pq.offer(sum);
        }

        System.out.println(answer);
    }
}