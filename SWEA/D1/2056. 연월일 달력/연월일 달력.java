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
            
            int year = Integer.parseInt(str.substring(0,4));
            int month = Integer.parseInt(str.substring(4,6));
            int day = Integer.parseInt(str.substring(6,8));
            if(month < 1 || month > 12 ||
               day > arrDay[month -1] || day<1){
                System.out.println("#" +i + " -1");
                continue;
            }
            
            StringBuilder sb = new StringBuilder(str);
            sb.insert(4,"/");
            sb.insert(7,"/");
            System.out.println("#" + i + " " + sb);
        }
    }
}