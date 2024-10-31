import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 1 ; i <= testCase ; i++){
            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            
            while(st.hasMoreTokens())
                list.add(Integer.parseInt(st.nextToken()));

            int hour = list.get(0) + list.get(2);
            int minute = list.get(1) + list.get(3);

            if(minute > 59){
                minute -= 60;
                hour += 1;
            }

            if(hour == 24)
                hour = 12;
            else if(hour > 12)
                hour %= 12;

            System.out.println("#" + i + " " + hour + " " + minute);
        }
    }
}