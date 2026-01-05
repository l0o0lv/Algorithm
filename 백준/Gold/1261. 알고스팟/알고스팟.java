import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] map;
    static int n, m;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node{
        int x, y, skill;

        public Node(int x, int y, int skill){
            this.x = x;
            this.y = y;
            this.skill = skill;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            String text = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = text.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs(){
        Deque<Node> q = new ArrayDeque<>();
        q.offerFirst(new Node(0, 0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Node now = q.pollFirst();

            if(now.x == n -1 && now.y == m -1) return now.skill;

            for(int i = 0 ; i < 4 ; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    q.offerLast(new Node(nx, ny, now.skill + 1));
                    visited[nx][ny] = true;
                }

                if(map[nx][ny] == 0 && !visited[nx][ny]){
                    q.offerFirst(new Node(nx, ny, now.skill));
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}