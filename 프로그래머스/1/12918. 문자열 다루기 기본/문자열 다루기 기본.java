class Solution {
    public boolean solution(String s) {
        
        if(s.length() != 4 && s.length() != 6)
            return false;
        
        boolean answer = true;
        char[] arr = s.toCharArray();
        
        for(int i = 0 ; i < arr.length ; i++){
             if(arr[i] >= '0' && arr[i] <= '9')
                continue;
            else
                return false;
        }
        return answer;
    }
}