import java.util.*;

class Solution {
    static HashSet<Integer> hs;
    static boolean[] visited;
    
    public int solution(String numbers) {
        hs = new HashSet<>();
        visited = new boolean[numbers.length()];
        int answer = 0;
        
        dfs(numbers, "");
        
        for(int num : hs){
            if(isPrime(num)) answer++;
        
        }
        return answer;
    }
    
    static void dfs(String numbers, String now){
        for(int i = 0 ; i < numbers.length() ; i++){
            if(!visited[i]){
                visited[i] = true;
                
                String next = now + numbers.charAt(i);
                hs.add(Integer.parseInt(next));
                dfs(numbers, next);
                
                visited[i] = false;
            }
                
        }
    }
    
    static boolean isPrime(int num){
        if(num < 2) return false;
        
        for(int i = 2; i * i <= num ; i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}