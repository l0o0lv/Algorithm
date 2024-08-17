import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int number = 0;
        
        for(int i = 0 ; i < photo.length ; i++){
            for(int j = 0 ; j < photo[i].length; j ++){
                if(Arrays.asList(name).contains(photo[i][j]))
                    number += yearning[Arrays.asList(name).indexOf(photo[i][j])];
            }
            answer[i] = number;
            number = 0;
        }
        return answer;
    }
}