import java.util.*;
import java.io.*;

class Solution {
    static int N, M;
    static int count;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    static void bfs(int index){
        Queue<Integer> q = new LinkedList<>();

        q.offer(index);
        visited[index] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : graph.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        count++;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= testCase ; tc++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            count = 0;
            visited = new boolean[N + 1];
            
            for(int i = 0 ; i < N + 1 ; i++){
                graph.add(new ArrayList<>());
            }

            for(int i = 0 ; i < M ; i++){
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            for(int i = 1 ; i < N + 1 ; i++){
                if(!visited[i]) bfs(i);
            }

            bw.write("#" + tc + " " + count + "\n");
        }
        bw.flush();
    }
}