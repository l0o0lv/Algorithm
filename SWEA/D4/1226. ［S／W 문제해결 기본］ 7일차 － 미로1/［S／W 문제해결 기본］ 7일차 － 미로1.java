import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    static int[][] arr;
    static int startX, startY;

    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int bfs(){
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(startX, startY));

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextX >= 16 ||
                   nextY < 0 || nextY >= 16 ||
                  arr[nextX][nextY] == 1) continue;
                if(visited[nextX][nextY]) continue;

                if(arr[nextX][nextY] == 3) return 1;
                q.add(new Node(nextX, nextY));
                visited[nextX][nextY] = true;
                
            }
        }
        return 0;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int tc = 1 ; tc <= 10 ; tc++){
            br.readLine();
            visited = new boolean[16][16];
            arr = new int[16][16];
            for(int i = 0 ; i < 16 ; i++){
                String text = br.readLine();
                for(int j = 0 ; j < 16 ; j++){
                    arr[i][j] = text.charAt(j) - '0';
                    if(arr[i][j] == 2){
                        startX = i;
                        startY = j;
                    }
                }
            }
            System.out.println("#" + tc + " " + bfs());
        }
    }
}