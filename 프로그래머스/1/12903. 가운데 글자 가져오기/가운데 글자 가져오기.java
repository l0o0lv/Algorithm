class Solution {
    public String solution(String s) {
        String answer = "";
        int midNum = s.length() / 2;
        if(s.length() % 2 == 0)
            answer = s.substring(midNum - 1 , midNum + 1);
        else
            answer = s.substring(midNum,midNum+1);
        return answer;
    }
}