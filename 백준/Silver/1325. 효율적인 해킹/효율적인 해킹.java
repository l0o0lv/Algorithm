import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] hackingCount;
    static int maxHackingCount, count;

    static int bfs(int index){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N+1];

        visited[index] = true;
        q.offer(index);
        count = 1;
        
        while(!q.isEmpty()){
            int now = q.poll();

            for(int i = 0 ; i < graph[now].size() ; i++){
                if(!visited[graph[now].get(i)]){
                    visited[graph[now].get(i)] = true;
                    q.add(graph[now].get(i));
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        hackingCount = new int[N+1];

        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        maxHackingCount = 0;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a); // 역으로 출발. 1~2~3~4
        }

        for(int i = 1 ; i <= N ; i++){
            count = bfs(i);
            hackingCount[i] = count;
            maxHackingCount = Math.max(maxHackingCount, count);
        }

        for(int i = 1; i <= N ; i ++){
            if(hackingCount[i] == maxHackingCount){
                sb.append(i + " ");
            }
        }
        System.out.print(sb);
    }
}