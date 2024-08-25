class Solution {
    public int solution(int n, int m, int[] section) {
        int paint = (m-1) + section[0];
        int count = 1;
        
        for(int i = 1 ; i < section.length ; i++){
            if(section[i] <= paint)
                continue;
            else{
                paint = (m-1) + section[i];
                count++;
            }
        }
        return count;
    }
}