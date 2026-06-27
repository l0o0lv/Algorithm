import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        Stack<String> stack = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                stack.push("(");
            }
            else if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    stack.push(")");
                }
                else{
                    if(stack.peek().equals("(")){
                        stack.pop();
                    }
                }
            }
        }

        if(stack.size() == 0) answer = true;
        return answer;
    }
}