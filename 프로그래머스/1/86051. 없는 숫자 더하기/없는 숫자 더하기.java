class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] number_exists = new boolean[10];

        for(int i = 0 ; i<numbers.length; i++){
            number_exists[numbers[i]] = true;
        }
        
        for(int i = 0; i<10 ; i++)
            if(!number_exists[i])
                answer += i;
        return answer;
    }
}