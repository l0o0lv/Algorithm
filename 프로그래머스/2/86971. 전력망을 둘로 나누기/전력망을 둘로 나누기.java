import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0 ; i <= n ; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < wires.length ; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        for(int i = 0 ; i < wires.length ; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            list.get(a).remove(Integer.valueOf(b));
            list.get(b).remove(Integer.valueOf(a));
            
            int cnt = bfs(list, 1, n);
            
            answer = Math.min(answer, Math.abs((n - cnt) - cnt));
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        return answer;
    }
    
    static int bfs(List<List<Integer>> list, int start, int n){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        
        int cnt = 1;
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            List<Integer> nextWire = list.get(now);
            for(int i = 0 ; i < nextWire.size() ; i++){
                int next = nextWire.get(i);
                
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}