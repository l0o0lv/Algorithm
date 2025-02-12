import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] miro;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0}; // dy dx 탐색법. 상하
    static int[] dy = {0, 0, -1, 1}; // 좌우

    private static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N + 1][M + 1];
        visited = new boolean[N+1][M+1];

        for(int i = 1 ; i <= N ; i++){
            String text = br.readLine();
            for(int j = 1 ; j <= M ; j++){
                miro[i][j] = text.charAt(j - 1) - '0';
            }
        }
        BFS();

        System.out.println(miro[N][M]);
    }

    static void BFS(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1,1));
        visited[1][1] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX <= N && nextY <=M && miro[nextX][nextY] != 0 && !visited[nextX][nextY]){
                    q.offer(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                    miro[nextX][nextY] = miro[now.x][now.y] + 1;
                }
            }
        }
    }
}