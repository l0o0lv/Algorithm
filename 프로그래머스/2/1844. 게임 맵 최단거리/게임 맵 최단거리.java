import java.util.*;

class Solution {
    static boolean[][] visited;
    static int answer;
    static int dx[] = {1, -1, 0 , 0};
    static int dy[] = {0, 0, 1, -1};
    
    static class Node{
        int x, y, dist;
        
        public Node(int x, int y , int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int solution(int[][] maps) {
        answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        
        answer = bfs(maps);
        return answer;
    }
    
    static int bfs(int[][] maps){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.x == maps.length - 1 && now.y == maps[0].length - 1){
                return now.dist;
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx >= maps.length || nx < 0 || ny >= maps[0].length || ny < 0) continue;
                if(maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, now.dist + 1));
                }
            }
        }
        return -1;
    }
}