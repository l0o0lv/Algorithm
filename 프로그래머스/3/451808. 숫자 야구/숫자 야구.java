import java.util.*;
import java.util.function.Function;

class Solution {
    private String score(int secret, int guess) {
        int strike = 0, ball = 0;
        int[] s = toDigits(secret);
        int[] g = toDigits(guess);
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (s[i] == g[j]) {
                    if (i == j) strike++;
                    else ball++;
                }
            }
        }
        return strike + "S " + ball + "B";
    }
    
    private int[] toDigits(int num) {
        int[] d = new int[4];
        for (int i = 3; i >= 0; i--) {
            d[i] = num % 10;
            num /= 10;
        }
        return d;
    }
    
    private List<Integer> makeCandidates() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1000; i <= 9999; i++) {
            int[] d = toDigits(i);
            boolean valid = true;
            for(int x : d){
                if(x == 0) {
                    valid = false;
                    break;
                }
            } 
            if (!valid) continue;
            
            Set<Integer> set = new HashSet<>();
            for (int x : d) set.add(x);
            if (set.size() == 4) list.add(i);
        }
        return list;
    }
    
    public int solution(int n, Function<Integer, String> submit) {
        List<Integer> candidates = makeCandidates();
        
        for (int i = 0; i < n; i++) {
            int guess = candidates.get(0);
            String hint = submit.apply(guess);
            
            if (hint.equals("4S 0B")) return guess;
            
            List<Integer> next = new ArrayList<>();
            for (int c : candidates) {
                if (score(c, guess).equals(hint)) next.add(c);
            }
            candidates = next;
        }
        
        return candidates.get(0);
    }
}