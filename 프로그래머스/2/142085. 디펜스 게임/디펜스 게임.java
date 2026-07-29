import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for(int i = 0 ; i < enemy.length ; i++){
            n -= enemy[i];
            q.offer(enemy[i]);
            
            if(n < 0){
                if(k > 0){
                    n += q.poll();
                    k--;
                }
                else{
                    return i;
                }
            }
        }
        answer = enemy.length;
        return answer;
    }
}