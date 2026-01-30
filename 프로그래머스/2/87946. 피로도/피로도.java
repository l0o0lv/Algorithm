class Solution {
    static int answer = Integer.MIN_VALUE;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0, 0);
        return answer;
    }
    
    static void dfs(int k, int[][] dungeons, int clear, int cnt){
        if(cnt == dungeons.length){
            answer = Math.max(answer, clear);
            return;
        }
        
        for(int i = 0 ; i < dungeons.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                if(k >= dungeons[i][0]){
                    dfs(k - dungeons[i][1], dungeons, clear + 1, cnt + 1);
                }
                else{
                    dfs(k, dungeons, clear, cnt + 1);
                }
                visited[i] = false;
            }
        }
    }
}