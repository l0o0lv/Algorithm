import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = n - lost.length;
        List<Integer> list = new ArrayList<>();
        
        for(int i : reserve)
            list.add(i);
        
        for(int i = 0 ; i < lost.length ; i++){
            if(list.contains(lost[i])){
                list.remove(Integer.valueOf(lost[i]));
                answer++;
                lost[i] = -1;
            }
        }
        
        for(int i = 0 ; i < lost.length ; i ++){
            if(lost[i] == -1)
                continue;
            int num1 = lost[i] - 1;
            int num2 = lost[i] + 1;
            
            if(list.contains(num1)){
                list.remove(Integer.valueOf(num1));
                answer++;
                continue;
            }
            else if(list.contains(num2)){
                list.remove(Integer.valueOf(num2));
                answer++;
                continue;
            }
                
        }
        return answer;
    }
    
}