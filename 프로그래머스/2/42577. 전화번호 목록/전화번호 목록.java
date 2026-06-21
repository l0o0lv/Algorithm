import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> hs = new HashSet<>();
        
        for(String str: phone_book) hs.add(str);
        
        for(String str : hs){
            for(int i = 0 ; i < str.length() ; i++){
                if(hs.contains(str.substring(0, i))){
                    return false;
                }
            }
        }
        return true;
    }
}