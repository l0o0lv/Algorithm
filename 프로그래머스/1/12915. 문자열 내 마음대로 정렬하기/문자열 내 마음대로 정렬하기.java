import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        ArrayList<String> arr = new ArrayList<>();
        String[] answer = new String[strings.length];
        
        for(String i : strings){
            arr.add(i.charAt(n) + i);
        }
        Collections.sort(arr);
        
        for(int i = 0 ; i < arr.size() ; i ++){
            answer[i] = arr.get(i).substring(1,arr.get(i).length());
        }
        return answer;
    }
}