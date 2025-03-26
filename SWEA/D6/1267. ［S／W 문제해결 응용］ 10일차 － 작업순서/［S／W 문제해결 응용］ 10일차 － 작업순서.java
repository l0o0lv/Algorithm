import java.util.*;
import java.io.*;

class Solution {
    static int V, E;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();

    static void topological(){
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1 ; i <= V ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();

            if(indegree[now] == 0) sb.append(" " + now);

            ArrayList<Integer> list = graph.get(now);

            for(int i = 0 ; i < list.size() ; i++){
                int next = list.get(i);
                if(--indegree[next] == 0) q.offer(next);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int tc = 1 ; tc <= 10 ; tc++){
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            indegree = new int[V + 1];
            graph = new ArrayList<>();

            for(int i = 0 ; i <= V ; i++){
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < E ; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                indegree[b]++;
            }

            sb.append("#" + tc);
            topological();
            sb.append("\n");
            
        }
        System.out.print(sb);
    }
}