import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int answer = 0;
        int num = score.length - 1;
        
        Arrays.sort(score);
        
        for(int j = 0 ; j < score.length / m ; j++){
            ArrayList<Integer> list2 = new ArrayList<>();
            for(int n = 0 ; n < m ; n++){
                list2.add(score[num]);
                num--;
            }
                answer += m * Collections.min(list2);
                list2.clear();
        }
        return answer;
    }
}