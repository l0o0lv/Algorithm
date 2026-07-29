class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows + 1][columns + 1];
        int[] answer = new int[queries.length];
        int num = 1;
        
        for(int i = 1 ; i <= rows ; i++){
            for(int j = 1 ; j <= columns ; j++){
                map[i][j] = num;
                num++;
            }
        }
        
        for(int i = 0 ; i < queries.length ; i++){
            int x1 = queries[i][0]; // 2
            int y1 = queries[i][1]; // 2
            int x2 = queries[i][2]; // 5
            int y2 = queries[i][3]; // 4
            
            int temp = map[x1][y1];
            int minNum = map[x1][y1];
            for(int x = x1 ; x <= x2 - 1 ; x++){
                map[x][y1] = map[x+1][y1];
                minNum = Math.min(minNum, map[x][y1]);
            }
            for(int y = y1 ; y <= y2 - 1 ; y++){
                map[x2][y] = map[x2][y+1];
                minNum = Math.min(minNum, map[x2][y]);
            }
            for(int x = x2 ; x >= x1 + 1 ; x--){
                map[x][y2] = map[x - 1][y2];
                minNum = Math.min(minNum, map[x][y2]);
            }
            for(int y = y2 ; y >= y1 + 2 ; y--){
                map[x1][y] = map[x1][y - 1];
                minNum = Math.min(minNum, map[x1][y]);
            }
            map[x1][y1 + 1] = temp;
            answer[i] = minNum;
        }
        return answer;
    }
}