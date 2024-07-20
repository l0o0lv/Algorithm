import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pInt = Long.parseLong(p);
        for(int i = 0 ; i <= t.length() - p.length() ; i ++){
            long n = Long.parseLong(t.substring(i,i + (p.length())));
            if(n <= pInt)
                answer++;
        }
        return answer;
    }
}