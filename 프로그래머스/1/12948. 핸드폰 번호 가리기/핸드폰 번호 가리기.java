class Solution {
    public String solution(String phone_number) {
        String answer = "";
        StringBuilder sb = new StringBuilder(phone_number);
        for(int i = phone_number.length() - 5 ; i>=0 ; i--){
            sb.setCharAt(i,'*');
        }
        answer = sb.toString();
        return answer;
    }
}