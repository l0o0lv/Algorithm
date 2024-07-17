import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        for(int i = 1 ; i < arr.length ; i ++)
            for(int j = 0 ; j < arr.length - 1 ; j++){
                if(arr[j] < arr[j+1]){
                    char temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        return String.valueOf(arr);
    }
}