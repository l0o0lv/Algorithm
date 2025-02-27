import java.util.*;
import java.io.*;

class Solution {
    static int[][] mountain;
    static boolean[][] visited;
    static int length;
    static int N, K;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int maxHeight;
    static int answer;
    static int deleteCount;

    static void dfs(int i, int j, int length, int height, int deleteCount){
        answer = Math.max(answer, length);
        
        for(int next = 0 ; next < 4 ; next++){
            int nextX = i + dx[next];
            int nextY = j + dy[next];

            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
            if(visited[nextX][nextY]) continue;

            if(mountain[nextX][nextY] >= height){
                if(deleteCount == 1 && mountain[nextX][nextY] - K < height){
                    int calc = 0;
                    for(int construct = 1 ; construct <= K ; construct++){
                        if(mountain[nextX][nextY] - construct < height){
                            calc = mountain[nextX][nextY] - construct;
                            break;
                        }
                    }
                    visited[nextX][nextY] = true;
                    dfs(nextX, nextY, length + 1, calc, deleteCount - 1);
                    visited[nextX][nextY] = false;
                }
            } else{
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, length + 1, mountain[nextX][nextY], deleteCount);
                visited[nextX][nextY] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc <= testCase ; tc++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            mountain = new int[N][N];
            visited = new boolean[N][N];
            length = 1;
            answer = Integer.MIN_VALUE;
            maxHeight = 0;
            deleteCount = 1;
            
            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N ; j++){
                    mountain[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, mountain[i][j]);
                }
            }

            for(int i = 0 ; i < N ; i ++){
                for(int j = 0 ; j < N ; j++){
                    if(mountain[i][j] == maxHeight){
                        visited[i][j] = true;
                        dfs(i,j,1, mountain[i][j], deleteCount);
                        visited[i][j] = false;
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);

        }
        
        
    }
}