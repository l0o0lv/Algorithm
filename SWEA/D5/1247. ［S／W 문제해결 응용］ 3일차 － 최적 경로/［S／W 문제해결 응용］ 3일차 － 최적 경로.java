import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int startX, startY;
    static int endX, endY;
    static int minDistance;

    static void dfs(int customer, int nowX, int nowY, int distance){
        if(customer == N){
            distance += Math.abs(nowX - endX) + Math.abs(nowY - endY);
            minDistance = Math.min(minDistance, distance);
            return;
        }

        if(distance >= minDistance) return;

        for(int i = 0 ; i < N ; i++){
            if(!visited[i]){
                int nextX = map[i][0];
                int nextY = map[i][1];
                int nextDistance = Math.abs(nowX - nextX) + Math.abs(nowY - nextY);
                visited[i] = true;
                dfs(customer + 1, nextX, nextY, distance + nextDistance);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= testCase ; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][2];
            visited = new boolean[N];
            minDistance = Integer.MAX_VALUE;
            
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            for(int i = 0 ; i < N ; i++){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[i][0] = x;
                map[i][1] = y;
            }

            dfs(0, startX, startY, 0);

            System.out.println("#" + tc + " " + minDistance);
        }
    }
}