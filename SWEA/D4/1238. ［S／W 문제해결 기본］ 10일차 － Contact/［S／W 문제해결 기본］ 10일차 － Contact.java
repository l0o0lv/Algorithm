import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int[][] call;
    static int[] visited;
    static int start;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int tc = 1 ; tc <= 10 ; tc++){
            st = new StringTokenizer(br.readLine());

            int callLength = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());           

            call = new int[101][101];
            visited = new int[101];
            
            for(int i = 0 ; i < callLength / 2 ; i++){
                int fromNum = Integer.parseInt(st.nextToken());
                int toNum = Integer.parseInt(st.nextToken());

                call[fromNum][toNum] = 1;
            }
            
            System.out.println("#" + tc + " " + BFS());
        }
    }

    static int BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int depth = 1;
        visited[start] = depth;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next = 0 ; next < call[now].length ; next++){
                if(call[now][next] == 1 && visited[next] == 0){
                    q.offer(next);
                    visited[next] = visited[now] + 1;
                }

                depth = Math.max(depth, visited[next]);
            }
        }

        for(int i = 100 ; i >= 0 ; i--){
            if(depth == visited[i]){
                return i;
            }
        }
        return -1;
    }
}