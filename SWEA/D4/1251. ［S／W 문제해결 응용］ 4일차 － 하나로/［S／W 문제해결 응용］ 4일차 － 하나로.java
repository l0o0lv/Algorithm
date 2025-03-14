import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;
    static int[] x;
    static int[] y;
    static double E;
    static double[] minDistance;

    static class Node implements Comparable<Node>{
        int to;
        double value;

        public Node(int to, double value){
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node other){
            return Double.compare(this.value, other.value);
        }
    }
    
    static double prim(){
        Arrays.fill(minDistance, Double.MAX_VALUE);
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(0 , 0));
        int count = 0;
        double cost = 0;

        while(!pQ.isEmpty()){
            Node now = pQ.poll();
            int nowTo = now.to;
            double nowValue = now.value;

            if(visited[nowTo]) continue;
            visited[nowTo] = true;
            cost += nowValue;
            count++;

            if(count == N) break;

            for(int next = 0 ; next < N ; next++){
                double dist = Math.pow((x[nowTo] - x[next]),2) + Math.pow((y[nowTo] - y[next]),2);
                double weight = E * dist;

                if(minDistance[next] > weight){
                    minDistance[next] = weight;
                    pQ.offer(new Node(next, weight));
                }
            }
        }
        return cost; 
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc <= testCase ; tc++){
            N = Integer.parseInt(br.readLine());

            x = new int[N];
            y = new int[N];
            visited = new boolean[N];
            minDistance = new double[N];
            graph = new ArrayList<>();

            for(int i = 0 ; i < N ; i++){
                graph.add(new ArrayList<>());
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++){
                x[i] = Integer.parseInt(st.nextToken()); 
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++){
                y[i] = Integer.parseInt(st.nextToken()); 
            }

            E = Double.parseDouble(br.readLine());
            
            bw.write("#" + tc + " " + Math.round(prim()) + "\n");
        }
        bw.flush();
    }
}