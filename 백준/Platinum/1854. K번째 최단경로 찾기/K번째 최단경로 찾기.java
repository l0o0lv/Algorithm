import java.util.*;
import java.io.*;

class Main {
    static int N, M, K;
    static ArrayList<ArrayList<Node>> graph;
    static PriorityQueue<Integer>[] distQ;
    
    static class Node implements Comparable<Node> {
        int vertex, value;
        public Node(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Node other){
            return Integer.compare(this.value, other.value);
        }
    }

    static void dijkstra(){
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.add(new Node(1,0));
        distQ[1].add(0);

        while(!pQ.isEmpty()){
            Node now = pQ.poll();
            for(Node next : graph.get(now.vertex)){
                int distance = now.value + next.value;

                if(distQ[next.vertex].size() < K){
                    distQ[next.vertex].add(distance);
                    pQ.offer(new Node(next.vertex, distance));
                } else if(distQ[next.vertex].peek() > distance){
                    distQ[next.vertex].poll();
                    distQ[next.vertex].add(distance);
                    pQ.offer(new Node(next.vertex, distance));
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

        graph = new ArrayList<>();
        for(int i = 0 ; i < N + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        distQ = new PriorityQueue[N + 1];
        for(int i = 0 ; i <= N ; i++){
            distQ[i] = new PriorityQueue<>(K, Collections.reverseOrder());
        }

        dijkstra();

        for(int i = 1 ; i <= N; i++){
            if(distQ[i].size() == K){
                System.out.println(distQ[i].peek());
            } else {
                System.out.println("-1");
            }
        }
    }
}