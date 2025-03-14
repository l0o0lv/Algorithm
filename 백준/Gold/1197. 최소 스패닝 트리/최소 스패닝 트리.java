import java.util.*;
import java.io.*;

class Main {
    static int V, E;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph;
    static int answer;

    static class Node implements Comparable<Node>{
        int to;
        int value;

        public Node(int to, int value){
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node other){
            return Integer.compare(this.value, other.value);
        }
    }

    static void prim(int index){
        PriorityQueue<Node> pQ = new PriorityQueue<>();

        pQ.offer(new Node(index, 0));
        while(!pQ.isEmpty()){
            Node now = pQ.poll();
            int nowTo = now.to;
            int nowValue = now.value;

            if(visited[nowTo]) continue;
            visited[nowTo] = true;
            answer += nowValue;

            for(Node next : graph.get(nowTo)){
                if(!visited[next.to]){
                    pQ.offer(next);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();
        answer = 0;
        visited = new boolean[V + 1];

        for(int i = 0 ; i <= V ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        prim(1);

        System.out.println(answer);
    }
}