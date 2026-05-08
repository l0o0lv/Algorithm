class Solution {
    static int answer;
    static boolean visited[];
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0, 0);
        return answer;
    }
    
    static void dfs(int k, int[][] dungeons, int cnt, int now){
        if(now == dungeons.length){
            answer = Math.max(cnt, answer);
            return;
        }
        
        for(int i = 0 ; i < dungeons.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                if(k >= dungeons[i][0]) dfs(k - dungeons[i][1], dungeons, cnt + 1, now + 1);
                else dfs(k, dungeons, cnt, now + 1);
                visited[i] = false;
            }
        }
    }
}