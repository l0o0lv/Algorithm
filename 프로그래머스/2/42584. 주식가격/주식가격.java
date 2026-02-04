import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        
        for(int price : prices) q.offer(price);
        
        int index = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            int cnt = 0;
            for(int price : q){
                cnt++;
                if(now > price) break;
            }
            
            answer[index++] = cnt;
        }
        
        return answer;
    }
}