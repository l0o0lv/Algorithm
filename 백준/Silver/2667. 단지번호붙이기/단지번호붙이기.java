import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int roomCount;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y){
        roomCount = 1;
        Queue<Node> q = new LinkedList<>();

        visited[x][y] = true;
        q.offer(new Node(x,y));

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(visited[nextX][nextY] || map[nextX][nextY] == 0) continue;

                roomCount++;
                visited[nextX][nextY] = true;
                q.offer(new Node(nextX, nextY));
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            String text = br.readLine();
            for(int j = 0 ; j < N ; j++){
                map[i][j] = text.charAt(j) - '0';
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    bfs(i,j);
                    list.add(roomCount);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int num : list){
            System.out.println(num);
        }
    }
}