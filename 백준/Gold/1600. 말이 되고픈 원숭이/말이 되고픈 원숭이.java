import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int k, w, h;
    static int[][] map;
    static boolean[][][] visited;
    static int[] monkeyDx = {1, -1, 0, 0};
    static int[] monkeyDy = {0, 0, 1, -1};
    static int[] horesDx = {-1, -2, -1, -2, 1, 2, 2, 1};
    static int[] horseDy = {-2, -1, 2, 1, -2, -1, 1, 2};

    static class Node{
        int x, y, dist, skill;

        public Node(int x, int y, int dist, int skill){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.skill = skill;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w][k+1];

        for(int i = 0 ; i < h ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < w ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0, k));
        visited[0][0][k] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.x == h - 1 && now.y == w - 1) return now.dist;

            // 원숭이 이동
            for(int i = 0 ; i < 4 ; i++){
                int nx = now.x + monkeyDx[i];
                int ny = now.y + monkeyDy[i];

                if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;

                if(map[nx][ny] == 0 && !visited[nx][ny][now.skill]){
                    q.offer(new Node(nx, ny, now.dist + 1, now.skill));
                    visited[nx][ny][now.skill] = true;
                }
            }

            // 말 이동
            if(now.skill > 0){
                for(int i = 0 ; i < 8 ; i++){
                    int nx = now.x + horesDx[i];
                    int ny = now.y + horseDy[i];

                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;

                    if(map[nx][ny] == 0 && !visited[nx][ny][now.skill - 1]){
                        q.offer(new Node(nx, ny, now.dist +1, now.skill - 1));
                        visited[nx][ny][now.skill -1] = true;
                    }
                }
            }
        }
        return -1;
    }
}