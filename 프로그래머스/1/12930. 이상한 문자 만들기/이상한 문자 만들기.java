class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int num = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == ' ')
                num = 1;
            if(num % 2 == 0){
                sb.setCharAt(i,Character.toUpperCase(ch));
                num++;
            }
            else{
                sb.setCharAt(i,Character.toLowerCase(ch));
                num++;
            }
        }
        return sb.toString();
    }
}