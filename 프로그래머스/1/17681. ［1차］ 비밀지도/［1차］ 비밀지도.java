class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0 ; i < n ; i++)
            answer[i] = "";
        
        String zero = "0";
        String[] binary1 = new String[n];
        String[] binary2 = new String[n];
        
        for(int i = 0 ; i < n ; i++){
            binary1[i] = Integer.toBinaryString(arr1[i]);
            binary2[i] = Integer.toBinaryString(arr2[i]);
            
            if(binary1[i].length() < n)
                for(int j = binary1[i].length() ; j< n ; j ++)
                    binary1[i] = zero.concat(binary1[i]);
            if(binary2[i].length() < n)
                for(int j = binary2[i].length() ; j< n ; j ++)
                    binary2[i] = zero.concat(binary2[i]);
        }
        
        for(int i = 0 ; i < n ; i++){
           for(int j =  0; j < n ; j++){
               if(binary1[i].charAt(j) == '1' || binary2[i].charAt(j) ==  '1'){
                   answer[i] += "#";
               }
               else{
                   answer[i] += " ";
               }
           }
        }
        
        return answer;
    }
}