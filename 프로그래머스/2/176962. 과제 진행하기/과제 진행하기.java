import java.util.*;

class Solution {
    
    static class Study{
        String subject;
        int startTime;
        int playTime;
        
        public Study(String subject, int startTime, int playTime){
            this.subject = subject;
            this.startTime = startTime;
            this.playTime = playTime;
        }
    }
    
    public String[] solution(String[][] plans) {
        ArrayList<Study> studies = new ArrayList<>();
        Stack<Study> stack = new Stack<>();
        ArrayList<String> result = new ArrayList<>();
        
        for(String[] plan : plans){
            studies.add(
                new Study(plan[0]
                          ,stringToTime(plan[1])
                          ,Integer.parseInt(plan[2])
                         )
            );
        }
        
        Collections.sort(studies, (a,b) -> a.startTime - b.startTime);
        
        for(int i = 0 ; i < studies.size() ; i++){
            Study now = studies.get(i);
            
            if(i == studies.size() - 1){
                result.add(now.subject);
                break;
            }
            
            Study next = studies.get(i + 1);
            int nowEndTime = now.startTime + now.playTime;
            
            if(nowEndTime <= next.startTime){
                result.add(now.subject);
                int remainTime = next.startTime - nowEndTime;
                
                while(!stack.isEmpty() && remainTime > 0){
                    Study prev = stack.pop();
                    
                    if(prev.playTime <= remainTime){
                        result.add(prev.subject);
                        remainTime -= prev.playTime;
                    }
                    else{
                        prev.playTime -= remainTime;
                        stack.push(prev);
                        break;
                    }
                }
            }
            else{
                now.playTime = nowEndTime - next.startTime;
                stack.push(now);
            }
        }
        
        while(!stack.isEmpty()){
            result.add(stack.pop().subject);
        }
        
        String[] answer = new String[result.size()];
        
        for(int i = 0 ; i < result.size() ; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    public int stringToTime(String time){
        String[] timeArr = time.split(":");
        int toNum = 0;
        toNum += Integer.parseInt(timeArr[0]) * 60;
        toNum += Integer.parseInt(timeArr[1]);
        
        return toNum;
    }
}