import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] tomato;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, m, notRipenCount;
    static Queue<Node> q;

    static class Node{
        int x, y, day;

        public Node(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        tomato = new int[n][m];
        q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1) q.offer(new Node(i, j, 0));
                if(tomato[i][j] == 0) notRipenCount++;
            }
        }

        if(notRipenCount == 0){
            System.out.println("0");
            return;
        }

        int day = bfs();

        if(notRipenCount > 0){
            System.out.println("-1");
        }

        if(notRipenCount == 0){
            System.out.println(day);
        }
    }

    static int bfs(){
        int day = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            day = now.day;
            
            for(int i = 0 ; i < 4 ; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX >= 0 && nextX < n
                  && nextY >= 0 && nextY < m
                  && tomato[nextX][nextY] == 0){
                    notRipenCount--;
                    tomato[nextX][nextY] = 1;
                    q.offer(new Node(nextX, nextY, now.day + 1));
                  }
            }
        }
        return day;
    }
}