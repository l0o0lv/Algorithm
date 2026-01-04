import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m, k;
    static int[][] map;
    static boolean [][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node{
        int x, y, dist, breakCnt;

        public Node(int x, int y, int dist, int breakCnt){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.breakCnt = breakCnt;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[k + 1][n][m];

        for(int i = 0 ; i < n ; i++){
            String text = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = text.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, k));
        visited[k][0][0] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.x == n -1 && now.y == m -1){
                return now.dist;
            }

            for(int i = 0 ; i < 4 ; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >=m) continue;

                if(map[nx][ny] == 1 && now.breakCnt > 0 && !visited[now.breakCnt - 1][nx][ny]){
                    q.offer(new Node(nx, ny, now.dist + 1, now.breakCnt - 1));
                    visited[now.breakCnt - 1][nx][ny] = true;
                }

                if(map[nx][ny] == 0 && !visited[now.breakCnt][nx][ny]){
                    q.offer(new Node(nx, ny, now.dist + 1, now.breakCnt));
                    visited[now.breakCnt][nx][ny] = true;
                }
            }
        }

        return -1;
    }
}