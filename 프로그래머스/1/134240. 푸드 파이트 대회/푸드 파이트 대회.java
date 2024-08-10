class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1 ; i < food.length ; i++){
            for(int j = 0 ; j < food[i] / 2 ; j++)
                sb.append(Integer.toString(i));
        }
        String answer = sb.toString();
        answer += "0" + sb.reverse();
        return answer;
    }
}