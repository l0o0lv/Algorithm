class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length() == 4 || s.length() == 6)
            answer = true;
        else
            return false;
        
        char[] arr = s.toCharArray();
        
        for(int i = 0 ; i < arr.length ; i++){
             if((int)arr[i] >= 48 && (int)arr[i] <= 57)
                 continue;
            else
                return false;
        }
        return answer;
    }
}