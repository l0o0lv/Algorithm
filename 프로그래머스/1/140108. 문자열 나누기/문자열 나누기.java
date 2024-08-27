import java.util.*;

class Solution {
    public int solution(String s) {
        ArrayList<String> list = new ArrayList<>();
        int countCh1 = 0;
        int countCh2 = 0;
        int first = 0;
        
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(first) == s.charAt(i))
                countCh1++;
            else
                countCh2++;
            
            if(countCh1 == countCh2){
                list.add(s.substring(first,i+1));
                first = i+1;
                countCh1 = 0;
                countCh2 = 0;
            }
            else if(countCh1 != countCh2 && i == s.length() -1)
                list.add(s.substring(first,i+1));
        }
        return list.size();
    }
}