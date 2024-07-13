class Solution {
    public int solution(int n) {
        int answer = n;
        for(int i = n ; i > 0 ; i--){
            if(n % i == 1 && answer > i)
                answer = i;
        }
        return answer;
    }
}