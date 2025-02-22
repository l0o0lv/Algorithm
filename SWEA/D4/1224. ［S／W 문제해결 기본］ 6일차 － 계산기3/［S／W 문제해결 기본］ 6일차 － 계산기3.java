import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {    
            int textLength = Integer.parseInt(br.readLine());
            String text = br.readLine();
            Stack<Character> operator = new Stack<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < textLength; i++) {
                char letter = text.charAt(i);
                if (letter >= '0' && letter <= '9') {
                    sb.append(letter);
                } else if (letter == '*') {
                    operator.push(letter);
                } else if (letter == '+') {
                    while (!operator.isEmpty() && 
                           (operator.peek() == '*' || operator.peek() == '+')) {
                        sb.append(operator.pop());
                    }
                    operator.push(letter);
                } else if (letter == '(') {
                    operator.push(letter);
                } else if (letter == ')') {
                    while (true) {
                        if (!operator.isEmpty() && operator.peek() == '(') {
                            operator.pop();
                            break;
                        }
                        sb.append(operator.pop());
                    }
                }
            }
            
            while (!operator.isEmpty()) {
                sb.append(operator.pop());
            }

            Stack<Integer> calculate = new Stack<>();
            
            for(int i = 0 ; i < sb.length() ; i++){
                char letter = sb.charAt(i);

                if(letter >= '0' && letter <= '9'){
                    calculate.push(letter - '0');
                } else if(letter == '+'){
                    int a = calculate.pop();
                    int b = calculate.pop();

                    int sum = a + b;
                    calculate.push(sum);
                } else if(letter == '*'){
                    int a = calculate.pop();
                    int b = calculate.pop();

                    int sum = a * b;
                    calculate.push(sum);
                }
            }

            System.out.println("#" + tc + " " + calculate.pop());
        }
    }
}
