import java.util.*;

class Solution {
    static class Process{
        int index;
        int priority;
        
        public Process(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new ArrayDeque<>();
        
        for(int i = 0 ; i < priorities.length ; i++){
            q.offer(new Process(i, priorities[i]));
        }
        
        int cnt = 0;
        while(true){
            Process now = q.poll();
            
            boolean isMostPriority = true;
            for(Process p : q){
                if(now.priority < p.priority){
                    q.offer(now);
                    isMostPriority = false;
                    break;
                }
            }
            
            if(isMostPriority){
                cnt++;
                if(now.index == location) break;
            }
            
        }
        
        return cnt;
    }
}