import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean[][][] visited;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, m;

    static class Node{
        int x, y, distance, breakCnt;

        public Node(int x, int y, int distance, int breakCnt){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.breakCnt = breakCnt;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[2][n][m];
        map = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            String mapText = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = mapText.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs());
    }

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 1));
        visited[1][0][0] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.x == n - 1 && now.y == m -1){
                return now.distance;
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;

                int breakCnt = now.breakCnt;

                if(map[nextX][nextY] == 1){
                    if(breakCnt == 0) continue;
                    breakCnt--;
                }

                if(!visited[breakCnt][nextX][nextY]){
                    visited[breakCnt][nextX][nextY] = true;
                    q.offer(new Node(nextX, nextY, now.distance + 1, breakCnt));
                }
            }
        }
        return -1;
    }
}