class Solution {
    public int solution(int[][] sizes) {
        int max_garo = 0;
        int max_sero = 0;
        
        for(int i = 0 ; i < sizes.length ; i++){
            max_garo = Math.max(Math.max(sizes[i][0],sizes[i][1]), max_garo);
            max_sero = Math.max(Math.min(sizes[i][0],sizes[i][1]), max_sero);
        }
        return max_garo * max_sero;
    }
}