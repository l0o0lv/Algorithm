import java.util.*;
import java.io.*;

class Main {
    static int N, M, K, X;
    static ArrayList<Integer>[] graph;
    static int[] distance;
    
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();

        q.add(X);
        distance[X] = 0;

        while(!q.isEmpty()){
            int now  = q.poll();

            for(int next : graph[now]){
                if(distance[next] == -1){
                    distance[next] = distance[now] + 1;
                    q.add(next);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        distance = new int[N + 1];

        Arrays.fill(distance , -1);
        
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        bfs();

        boolean isPossible = false;
        for(int i = 1 ; i <= N ; i++){
            if(distance[i] == K){
                System.out.println(i);
                isPossible = true;
            }
        }

        if(!isPossible) System.out.println("-1");
    }
}