class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        long total_money = 0;
        
        for(int i = 1 ; i <= count ; i++){
            total_money += (price * i);
        }
        
        if(money > total_money) return 0;
        
        answer = total_money - money;
        return answer;
    }
}