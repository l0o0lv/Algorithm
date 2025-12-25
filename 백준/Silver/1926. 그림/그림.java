import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] picture;
    static boolean[][] visited;
    static int pictureCount, maxSize;
    static int n, m;
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
        pictureCount = 0;
        maxSize = 0;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        picture = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(picture[i][j] == 1 && !visited[i][j]){
                    pictureCount++;
                    maxSize = Math.max(maxSize, bfs(i, j));
                }
            }
        }
        System.out.println(pictureCount);
        System.out.println(maxSize);
    }

    static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visited[x][y] = true;
        int pictureSize = 0;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            pictureSize++;
            for(int i = 0 ; i < 4 ; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
                  && !visited[nextX][nextY] && picture[nextX][nextY] ==1) {
                    q.add(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                  }
            }
        }
        return pictureSize;
    }
}