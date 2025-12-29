import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int tc, n, m, k, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node{
        int x, y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        tc = Integer.parseInt(br.readLine());

        for(int testCase = 0 ; testCase < tc ; testCase++){
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            answer = 0;

            map = new int[n][m];
            visited = new boolean[n][m];

            for(int i = 0 ; i < k ; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        answer++;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(!visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }
}