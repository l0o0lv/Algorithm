class Solution {
    public int solution(int[] num_list) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        int answer = 0;
        
        for(int num : num_list){
            if(num % 2 == 0){
                even.append(String.valueOf(num));
            }
            else{
                odd.append(String.valueOf(num));
            }
        }
        
        answer = Integer.parseInt(even.toString()) + Integer.parseInt(odd.toString());
        return answer;
    }
}