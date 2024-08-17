import java.util.*;

class Solution {
    public int solution(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(!list.contains(nums[i]))
                list.add(nums[i]);
        }
        if(list.size() >= nums.length / 2)
            return nums.length / 2;
        else
            return list.size();
    }
}