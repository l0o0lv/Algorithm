import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int[][] miro;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1 ; tc <= 10 ; tc++){
            int testCase = Integer.parseInt(br.readLine());

            miro = new int[16][16];
            visited = new boolean[16][16];
            
            for(int i = 0 ; i < miro.length ; i++){
                String text = br.readLine();
                for(int j = 0 ; j < miro.length ; j++){
                    miro[i][j] = text.charAt(j) - '0';
                }
            }
            System.out.println("#" + tc + " " + BFS());
        }
    }

    static int BFS(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1,1));
        visited[1][1] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(int i = 0 ; i < 4 ; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(miro[nextX][nextY] == 3) return 1;
                if(miro[nextX][nextY] == 0 && !visited[nextX][nextY]){
                    q.offer(new Node(nextX,nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
        return 0;
    }
}