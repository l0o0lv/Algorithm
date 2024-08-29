class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int minIndex = 100;
        int count = 0;
        for(int i = 0 ; i < targets.length ; i++){
            for(int j = 0 ; j < targets[i].length() ; j++){
                for(int k = 0 ; k < keymap.length ; k++){
                    int index = keymap[k].indexOf(targets[i].charAt(j));
                    
                    if(index != -1)
                    minIndex = Math.min(index + 1, minIndex);
                }
                if(minIndex == 100){
                    count = -1;
                    break;
                }
                else{
                count += minIndex;
                minIndex = 100;
                }
            }
            answer[i] = count;
            count = 0;
        }
        return answer;
    }
}