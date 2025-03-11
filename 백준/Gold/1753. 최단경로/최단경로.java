import java.util.*;
import java.io.*;

class Main {
    static int V, E, K; // 정점 개수, 간선 개수, 시작 정점 번호
    static ArrayList<ArrayList<Node>> list;
    static int distance[];
    static boolean visited[];

    static class Node implements Comparable<Node>{
        int vertex, value;

        public Node(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Node n){
            return Integer.compare(this.value, n.value);
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        visited = new boolean[V + 1];
        list = new ArrayList<>();

        for(int i = 0 ; i < V + 1 ; i++) list.add(new ArrayList<>());
        for(int i = 1; i < V + 1 ; i++) distance[i] = Integer.MAX_VALUE;

        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, w));
        }

        PriorityQueue<Node> pQ = new PriorityQueue<>();

        pQ.offer(new Node(K, 0));
        distance[K] = 0;

        while(!pQ.isEmpty()){
            Node now = pQ.poll();
            int nowVertex = now.vertex;

            if(visited[nowVertex]) continue;
            visited[nowVertex] = true;

            ArrayList<Node> nextNode = list.get(nowVertex);

            for(int i = 0 ; i < nextNode.size(); i++){
                Node next = nextNode.get(i);
                int nextVertex = next.vertex;
                int nextValue = next.value;

                if(distance[nextVertex] > distance[nowVertex] + nextValue){
                    distance[nextVertex] = distance[nowVertex] + nextValue;
                    pQ.offer(new Node(nextVertex, distance[nextVertex]));
                }
            }
        }

        for(int i = 1 ; i < V + 1 ; i++){
            if(visited[i]) System.out.println(distance[i]);
            else System.out.println("INF");
        }
    }
}