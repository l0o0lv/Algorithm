import java.util.*;

class Solution {
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static boolean[][] visited;
    static int answer = 0;
    static int robotX,robotY;
    
    public int solution(String[] board) {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length() ; j++){
                if(board[i].charAt(j) == 'R'){
                    robotX = i;
                    robotY = j;
                }
            }
        }
        answer = bfs(robotX, robotY, board);
        return answer;
    }
    
    static int bfs(int x, int y, String[] board){
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[board.length][board[0].length()];
        q.offer(new int[] {x, y, 0});
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            if(board[now[0]].charAt(now[1]) == 'G'){
                return now[2];
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int nx = now[0];
                int ny = now[1];
                
                while(true){
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];
                    
                    if(tx < 0 || ty < 0 || tx >= board.length || ty >= board[0].length()) break;
                    if(board[tx].charAt(ty) == 'D') break;
                    
                    nx = tx;
                    ny = ty;
                }
                
                if(!visited[nx][ny]){
                    q.offer(new int[] {nx, ny, now[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}