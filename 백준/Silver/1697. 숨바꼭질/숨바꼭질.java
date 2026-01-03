import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, k, answer;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        answer = 0;

        if(n == k) {
            System.out.println(0);
            return;
        }
        
        bfs();

        System.out.println(answer);
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n]= true;

        while(true){
            answer++;

            int size = q.size();
            for(int i = 0 ; i < size ; i ++){
                int now = q.poll();

                if(now + 1 == k || now - 1 == k || now * 2 == k){
                    return;
                }
    
                if(now + 1 <= 100000 && !visited[now + 1]){
                    q.offer(now + 1);
                    visited[now + 1] = true;
                }
                if(now - 1 >= 0 && !visited[now - 1]){
                    q.offer(now - 1);
                    visited[now -1] = true;
                }
                if(now * 2 <= 100000 && !visited[now * 2]){
                    q.offer(now * 2);
                    visited[now * 2] = true;
                }
            }
        }
    }
}