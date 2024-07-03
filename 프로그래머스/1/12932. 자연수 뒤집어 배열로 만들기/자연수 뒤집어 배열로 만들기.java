class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        int[] answer = new int[str.length()];
        
        for (int i = 0; i < str.length(); i++) {
            // 각 자리 숫자를 역순으로 배열에 저장합니다.
            answer[i] = (int)(n % 10);
            // n을 10으로 나눠 마지막 자릿수를 제거합니다.
            n = n / 10;
        }
        return answer;
    }
}