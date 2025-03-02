import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 1 ; i <= 10 ; i++){
            int N = Integer.parseInt(br.readLine());
            char[] text = br.readLine().toCharArray();

            Stack<Character> stack = new Stack<>();

            for(int j = 0 ; j < N ; j++){
                char a = text[j];

                if(a == '}'){
                    if(!stack.isEmpty() && stack.peek() == '{'){
                        stack.pop();
                    } else{
                        break;
                    }
                } else if(a == ')') {
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    } else{
                        break;
                    }
                } else if(a == '>') {
                    if(!stack.isEmpty() && stack.peek() == '<'){
                        stack.pop();
                    } else{
                        break;
                    }
                } else if(a == ']') {
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    } else{
                        break;
                    }
                } else {
                    stack.push(a);
                }
            }
                if(stack.isEmpty()){
                    System.out.println("#" + i + " 1");
                } else{
                    System.out.println("#" + i + " 0");
                }
        }
    }
}