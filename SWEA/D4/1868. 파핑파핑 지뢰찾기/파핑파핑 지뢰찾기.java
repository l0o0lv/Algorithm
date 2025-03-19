import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static char[][] bomb;
    static int[][] bombCount;
    static boolean[][] visited;
    static int answer;
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int getMineCount(int x, int y){
        int count = 0;
        for(int i = 0 ; i < 8 ; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >=N) continue;
            if(bomb[nextX][nextY] == '*') count++;
        }
        return count;
    }

    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            int nowX = now.x;
            int nowY = now.y;

            for(int i = 0 ; i < 8 ; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >=N) continue;
                if(bombCount[nextX][nextY] != -1 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    if(bombCount[nextX][nextY] == 0) q.offer(new Node(nextX, nextY));
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc <= T ; tc++){
            N = Integer.parseInt(br.readLine());

            bomb = new char[N][N];
            bombCount = new int[N][N];
            visited = new boolean[N][N];
            answer = 0;
            
            for(int i = 0 ; i < N ; i++){
                String text = br.readLine();
                for(int j = 0 ; j < N ; j++){
                    bomb[i][j] = text.charAt(j);
                }
            }

            //지뢰 개수 계산
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(bomb[i][j] == '*'){
                        bombCount[i][j] = -1;
                    } else {
                        bombCount[i][j] = getMineCount(i, j);
                    }
                }
            }

            // 지뢰가 없는 지역 클릭
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(bombCount[i][j] == 0 && !visited[i][j]){
                        bfs(i,j);
                        answer++;
                    }
                }
            }
            
            // 숫자가 있는데 클릭하지 않은 곳 클릭
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(bombCount[i][j] > 0 && !visited[i][j]){
                        answer++;
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}