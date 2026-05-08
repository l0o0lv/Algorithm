class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    static void dfs(int[] numbers, int target, int now, int idx){
        if(idx == numbers.length){
            if(target == now) answer++;
            return;
        }
        
        dfs(numbers, target, now - numbers[idx], idx + 1);
        dfs(numbers, target, now + numbers[idx], idx + 1);
    }
}