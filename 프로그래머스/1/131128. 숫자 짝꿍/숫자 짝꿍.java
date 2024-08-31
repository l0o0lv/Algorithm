import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        int[] intX = new int[10];
        int[] intY = new int[10];
        
        for(int i = 0 ; i < X.length(); i++){
            intX[X.charAt(i) - '0']++;
        }
        for(int i = 0 ; i < Y.length() ; i++){
            intY[Y.charAt(i) - '0']++;
        }
        
        for(int i = 9 ; i >= 0 ; i--){
            while(intX[i] > 0 && intY[i] > 0){
                intX[i]--;
                intY[i]--;
                answer.append(i);
            }
        }
        
        if(answer.toString().equals(""))
            return "-1";
        else if(answer.toString().startsWith("0"))
            return "0";
        
        return answer.toString();
    }
}