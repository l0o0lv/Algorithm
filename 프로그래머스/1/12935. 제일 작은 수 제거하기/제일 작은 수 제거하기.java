import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : arr)
            list.add(i);
        
        int min = Collections.min(list);
        list.remove(list.indexOf(min));
        
        if(list.isEmpty())
            list.add(-1);
        
        return list;
    }
}