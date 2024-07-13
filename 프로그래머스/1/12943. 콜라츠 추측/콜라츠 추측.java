class Solution {
    public int solution(int num) {
        if(num == 0)
            return 0;
        
        int answer = 0;
        
        while(num != 1){
            if(answer == 500)
                return -1;
            
            if(num % 2 == 0)
                num /= 2;
            else if(num % 2 == 1)
                num = num * 3 + 1;
            answer++;
        }
        return answer;
    }
}