import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m, k;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static class Node{
        int x, y, dist, breakCnt;
        boolean isDay;

        public Node(int x, int y, int dist, int breakCnt, boolean isDay){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.breakCnt = breakCnt;
            this.isDay = isDay;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][k+1];
        
        for(int i = 0 ; i < n ; i++){
            String text = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = text.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    static int bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0,0, 1, k, true));
        visited[0][0][k] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.x == n-1 && now.y == m-1) return now.dist;

            for(int i = 0 ; i < 4 ; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(map[nx][ny] == 1 && now.breakCnt > 0 && !visited[nx][ny][now.breakCnt -1]){
                    if(now.isDay){
                        q.offer(new Node(nx, ny, now.dist + 1, now.breakCnt - 1, !now.isDay));
                        visited[nx][ny][now.breakCnt - 1] = true;
                    }
                    else{
                        q.offer(new Node(now.x, now.y, now.dist +1, now.breakCnt, !now.isDay));
                    }
                }
                else if(map[nx][ny] == 0 && !visited[nx][ny][now.breakCnt]){
                    q.offer(new Node(nx, ny, now.dist + 1, now.breakCnt, !now.isDay));
                    visited[nx][ny][now.breakCnt] = true;
                }
            }
        }
        return -1;
    }
}