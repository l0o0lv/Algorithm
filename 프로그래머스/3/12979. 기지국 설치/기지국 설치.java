import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int pos = 1;
        int stationScope = w * 2 + 1;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int station : stations){
            int discover = station - w;
            
            if(pos < discover){
                double size = discover - pos;
                answer += Math.ceil(size / stationScope);
                list.add(discover - pos);
            }
            pos = station + w + 1;
        }
        
        if(pos <= n) {
            double size = n - pos + 1;
            answer += Math.ceil(size / stationScope);
        }

        return answer;
    }
}