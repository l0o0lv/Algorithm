import java.util.*;

class Solution {
    
    static class Disk{
        int num, request, require;
        
        public Disk(int num, int request, int require){
            this.num = num;
            this.request = request;
            this.require = require;
        }
    }
    
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));        
        
        PriorityQueue<Disk> pq = new PriorityQueue<>((a, b) -> {
            if(a.require == b.require){
                if(a.request == b.request){
                    return Integer.compare(a.num, b.num);
                }
                return Integer.compare(a.request, b.request);
            }
            return Integer.compare(a.require, b.require);
        });
        
        int idx = 0;
        int current = 0;
        int complete = 0;
        int turnAroundTime = 0;
        
        while(complete < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= current){
                pq.offer(new Disk(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(pq.isEmpty()){
                current = jobs[idx][0];
                continue;
            }
            
            Disk now = pq.poll();
            current += now.require;
            turnAroundTime += (current - now.request);
            complete++;
        }
        
        
        return turnAroundTime / jobs.length;
    }
}