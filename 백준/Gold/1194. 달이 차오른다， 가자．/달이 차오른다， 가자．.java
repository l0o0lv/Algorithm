import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int startX, startY;
    static char[][] miro;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node{
        int x;
        int y;
        int count;
        int key;

        public Node(int x, int y , int count, int key){
            this.x = x;
            this.y = y;
            this.count = count;
            this.key = key;
        }
    }

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX, startY, 0, 0));
        visited[startX][startY][0] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(miro[now.x][now.y] == '1') return now.count;
            
            for(int i = 0 ; i < 4 ; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M ||
                   miro[nextX][nextY] == '#' || visited[nextX][nextY][now.key]) continue;

                if(miro[nextX][nextY] >= 'a' && miro[nextX][nextY] <= 'f'){
                    int nextKey = now.key | (1 << (miro[nextX][nextY] - 'a'));
                    visited[nextX][nextY][nextKey] = true;
                    q.offer(new Node(nextX, nextY, now.count + 1, nextKey));
                } 
                else if(miro[nextX][nextY] >= 'A' && miro[nextX][nextY] <= 'F'){
                    int validOpen = now.key & (1 << (miro[nextX][nextY] - 'A'));
                    if(validOpen != 0){
                        visited[nextX][nextY][now.key] = true;
                        q.offer(new Node(nextX, nextY, now.count + 1, now.key));
                    }
                } 
                else {
                    visited[nextX][nextY][now.key] = true;
                    q.offer(new Node(nextX, nextY, now.count + 1 , now.key));
                } 
            }
        }
        return -1;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new char[N][M];
        visited = new boolean[N][M][64];

        for(int i = 0 ; i < N ; i++){
            String text = br.readLine();
            for(int j = 0 ; j < M ; j++){
                miro[i][j] = text.charAt(j);
                if(miro[i][j] == '0'){
                    startX = i;
                    startY = j;
                }
            }
        }
        System.out.println(bfs());
    }
}