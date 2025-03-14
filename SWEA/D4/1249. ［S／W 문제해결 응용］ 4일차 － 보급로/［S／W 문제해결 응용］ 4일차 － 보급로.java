import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int value;

        public Node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Node other){
            return Integer.compare(this.value, other.value);
        }
    }
    
    static void dijkstra(){
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(0,0, map[0][0]));
        dist[0][0] = map[0][0];
        
        while(!pQ.isEmpty()){
            Node now = pQ.poll();
            int nowX = now.x;
            int nowY = now.y;
            int nowValue = now.value;

            if(nowX == N - 1 && nowY == N -1) return;
            
            for(int i = 0 ; i < 4 ; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;

                int nextValue = nowValue + map[nextX][nextY];

                if(nextValue < dist[nextX][nextY]) {
                    dist[nextX][nextY] = nextValue;
                    pQ.add(new Node(nextX, nextY, nextValue));
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc <= testCase ; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];

            for(int i = 0 ; i < N ; i++){
                String text = br.readLine();
                for(int j = 0 ; j < N ; j++){
                    map[i][j] = text.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            dijkstra();
            bw.write("#" + tc + " " + dist[N-1][N-1] + "\n");
        }
        bw.flush();
    }
}