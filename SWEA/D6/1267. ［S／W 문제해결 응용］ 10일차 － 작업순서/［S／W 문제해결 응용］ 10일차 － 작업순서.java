import java.util.*;
import java.io.*;

class Solution {
    static int V, E;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] inDegree;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void topological() throws Exception{
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1 ; i < V + 1; i++){
            if(inDegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            bw.write(" " + now);
            for(int next : graph.get(now)){
                if(--inDegree[next] == 0){
                    q.offer(next);
                }
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

            graph = new ArrayList<>();
            inDegree = new int[V + 1];
            
            for(int i = 0 ; i < V + 1 ; i++){
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());

            for(int i = 0 ; i < E ; i++){
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());    

                graph.get(u).add(v);
                inDegree[v]++;
            }

            bw.write("#" + tc);
            topological();
            bw.write("\n");
        }
        bw.flush();
    }
}