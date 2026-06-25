import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int cnt = k;
        for(int i = 0 ; i < number.length() ; i ++){
            int num = number.charAt(i) - '0';
            
            while(!stack.isEmpty() && cnt > 0 && num > stack.peek() - '0'){
                stack.pop();
                cnt--;
            }
            
            stack.push(number.charAt(i));
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            sb.append(String.valueOf(stack.pop()));
        }
        
        return sb.reverse().toString().substring(0, number.length() - k);
    }
}