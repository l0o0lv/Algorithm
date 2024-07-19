import java.util.*;

class Solution {
    public int solution(int n) {
        int multiple = 0;
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
    
        while(n!=0){
            list.add(n % 3);
            n /= 3;

        }
        Collections.reverse(list);
        
        for(int i : list){
            answer +=(int) (i * Math.pow(3,multiple++));
        }
        return answer;
    }
}