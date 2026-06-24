class Solution {
    static boolean[][] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n][n];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(computers[i][j] == 1 && !visited[i][j]){
                    answer++;
                    dfs(n, i, j, computers);
                }
            }
        }
        return answer;
    }
    
    static void dfs(int n, int x, int y, int[][] computers){
        visited[x][y] = true;
        
        for(int i = 0 ; i < n ; i++){
            if(computers[y][i] == 1 && !visited[y][i]){
                dfs(n, y, i, computers);
            }
        }
    }
}