class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    static void dfs(int[] numbers, int index, int now, int target){
        if(index == numbers.length){
            if(now == target) answer++;
            return;
        }
        
        dfs(numbers, index + 1, now + numbers[index], target);
        dfs(numbers, index + 1, now - numbers[index], target);
        
    }
}