class Solution {
    static int answer;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];
        
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }
    
    static void dfs(int x, int[][] computers){
        visited[x] = true;
        
        for(int i = 0 ; i < computers[0].length ; i++){
            if(computers[x][i] == 1 && !visited[i]){
                dfs(i, computers);
            }
        }
    }
}