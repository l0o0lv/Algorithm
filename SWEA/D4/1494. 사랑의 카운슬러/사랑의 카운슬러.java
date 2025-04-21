import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static int[][] worm;
    static boolean[] visited;
    static long answer;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= testCase ; tc++){
            N = Integer.parseInt(br.readLine());
            answer = Long.MAX_VALUE;
            worm = new int[N][2];
            visited = new boolean[N];
            
            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                worm[i][0] = Integer.parseInt(st.nextToken());
                worm[i][1] = Integer.parseInt(st.nextToken());
            }

            combination(0,0);

            System.out.println("#" + tc + " " + answer);
        }
    }

    static void combination(int count, int start){
        if(count == N /2){
            long dx = 0;
            long dy = 0;

            for(int i = 0 ; i < N ; i++){
                if(visited[i]){
                    dx += worm[i][0];
                    dy += worm[i][1];
                }
                else{
                    dx -= worm[i][0];
                    dy -= worm[i][1];
                }
            }
            long vectorDistance = (dx * dx) + (dy * dy);
            answer = Math.min(answer, vectorDistance);
            return;
        }

        for(int i = start ; i < N ; i++){
            visited[i] = true;
            combination(count + 1, i + 1);
            visited[i] = false;
        }
    }
}