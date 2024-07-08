import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = Long.toString(n);
        int[] num = new int[str.length()];
        
        for (int i = 0; i < str.length(); i++){
            num[i] = str.charAt(i) - '0';
        }
        Arrays.sort(num);
        
        StringBuilder sb = new StringBuilder();
        for (int i : num)
            sb.append(i);
        
        answer = Long.parseLong(sb.reverse().toString());
        return answer;
    }
}