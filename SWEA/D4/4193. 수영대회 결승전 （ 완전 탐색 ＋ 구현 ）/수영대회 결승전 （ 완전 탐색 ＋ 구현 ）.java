import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int[][] sea;
    static boolean[][] visited;
    static int start;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int startX, startY;
    static int finishX, finishY;
    static int N;
    static int answer;
    
    public static class Node{
        int x,y, depth;
        public Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= testCase ; tc++){
            N = Integer.parseInt(br.readLine());       

            sea = new int[N][N];
            visited = new boolean[N][N];
            
            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N ; j++){
                    sea[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            finishX = Integer.parseInt(st.nextToken());
            finishY = Integer.parseInt(st.nextToken());
            
            System.out.println("#" + tc + " " + BFS());
        }
    }

    static int BFS(){
        Queue<Node> q = new LinkedList<>();
        int depth = 0;
        q.offer(new Node(startX, startY, depth));
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            // System.out.println("좌표: " + now.x + " " + now.y + " visited: " + visited[now.x][now.y]);

            for(int i = 0 ; i < 4 ; i ++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;

                if(nextX == finishX && nextY == finishY){
                    answer = now.depth + 1;
                    return answer;
                }
                
                if(sea[nextX][nextY] == 1 || visited[nextX][nextY]) continue;
                
                if(sea[nextX][nextY] == 2){
                    if(now.depth % 3 == 2){
                        visited[nextX][nextY] = true;
                        q.offer(new Node(nextX, nextY, now.depth + 1));
                    } else {
                        visited[now.x][now.y] = true;
                        q.offer(new Node(now.x,now.y,now.depth + 1));
                    }
                } else{
                    visited[nextX][nextY] = true;
                    q.offer(new Node(nextX, nextY, now.depth + 1));
                }
            }
        }

        return -1;
    }
}