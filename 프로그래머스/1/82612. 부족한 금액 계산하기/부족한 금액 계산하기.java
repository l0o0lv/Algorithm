class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long total_price = 0;
        for(int i = 0 ; i < count ; i++){
            total_price += (price * (i + 1));
        }
        total_price -= money;
        if(total_price <= 0)
            return 0;
        else
            return total_price;
    }
}