import java.util.*;

class Solution {
    static Queue<Function> q;
    static ArrayList<Integer> list;
    
    static class Function{
        int progress, speed;
        
        public Function(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
    }
    public int[] solution(int[] progresses, int[] speeds) {
        q = new ArrayDeque<>();
        list = new ArrayList<>();
        for(int i = 0 ; i < progresses.length ; i++){
            q.offer(new Function(progresses[i], speeds[i]));
        }
        
        int day = 1;
        
        while(!q.isEmpty()){
            int cnt = 0;
            
            while(!q.isEmpty() && q.peek().progress + q.peek().speed * day >= 100){
                q.poll();
                cnt++;
            }
            
            if(cnt > 0) list.add(cnt);
            day++;
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0 ; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}