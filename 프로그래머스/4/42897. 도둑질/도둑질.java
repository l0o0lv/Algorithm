class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        
        // 3이면 세 개 중에서 고르고 끝냄
        if(n == 3) return Math.max(money[0], Math.max(money[1], money[2]));
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        // 첫 번째 집을 터는 경우
        // 마지막 집과는 인접하니 털면 안된다.
        dp1[0] = money[0];
        dp1[1] = money[0]; // 바로 옆은 못 터니 똑같은 값으로
        
        for(int i = 2 ; i < n - 1 ; i++){
            // i 번째를 안 터는 경우와 터는 경우를 비교해야 한다.
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }
        
        // 두 번째 집부터 터는 경우
        // 마지막 집을 털어도 인접하지 않는다.
        dp2[0] = 0;
        dp2[1] = money[1]; // 1번 집을 고르지 않고 2번 집을 고르지 않는 경우의 수도 생각해야 한다.
        dp2[2] = Math.max(money[1], money[2]);
        
        for(int i = 3 ; i < n ; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        
        answer = Math.max(dp1[n-2], dp2[n-1]);
        return answer;
    }
}