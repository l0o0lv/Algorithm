import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, k;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    static class Node{
        int loc, second;

        public Node(int loc, int second){
            this.loc = loc;
            this.second = second;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        visited = new boolean[100001];
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(answer);
    }

    static int bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(n, 0));
        
        while(!q.isEmpty()){
            int size = q.size();

            Node now = q.poll();
            int loc = now.loc;
            visited[loc] = true;
                
            if(loc == k){
                answer = Math.min(answer, now.second);
            }

            if(loc * 2 < 100001 && !visited[loc * 2]){
                q.offer(new Node(loc * 2, now.second));
            }
                
            if(loc + 1 < 100001 && !visited[loc + 1]){
                q.offer(new Node(loc + 1, now.second + 1));
            }
    
            if(loc - 1 >= 0 && !visited[loc -1]){
                q.offer(new Node(loc - 1, now.second + 1));
            }
        }
        return 0;
    }
}