import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] ice;
    static int[][] melt;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int year;
    static class Node {
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        
        q.offer(new Node(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            int seaCount = 0;

            for(int i = 0 ; i < 4 ; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(ice[nextX][nextY] == 0) {
                    seaCount++;
                    continue;
                }
                if(!visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    q.offer(new Node(nextX, nextY));
                }
            }
            melt[now.x][now.y] = seaCount;
        }
    }

    static void meltIce(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(melt[i][j] > ice[i][j]){
                    ice[i][j] = 0;
                } else {
                    ice[i][j] -= melt[i][j];
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        year = 0;
        ice = new int[N][M];
        
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            visited = new boolean[N][M];
            melt = new int[N][M];
            int count = 0;
            
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M; j++){
                    if(ice[i][j] != 0 && !visited[i][j]) {
                        count++;
                        bfs(i,j);
                    }
                }
            }

            if(count == 0) {
                System.out.println("0");
                break;
            } else if(count >= 2){
                System.out.println(year);
                break;
            }

            meltIce();
            year++;
        }
    }
}