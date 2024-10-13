import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        int arrDay[] = {31,28,31,30,31,30,31,30,31,31,30,31,30,31};
        
        for(int i = 1 ; i <= num ; i++){
            String str = br.readLine();
            
            String year = str.substring(0,4);
            String month = str.substring(4,6);
            String day = str.substring(6,8);
            
            if(Integer.parseInt(month) < 1 || 
               Integer.parseInt(month) > 12 ||
               Integer.parseInt(day) > arrDay[Integer.parseInt(month)-1] || 
               Integer.parseInt(day) < 1){
                System.out.println("#" +i + " -1");
                continue;
            }

            System.out.println("#" + i + " " + year + "/" + month + "/" + day);
        }
    }
}