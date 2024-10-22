import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
        StringTokenizer st;
        
        for(int i = 1 ; i <= testCase ; i++){
            st = new StringTokenizer(br.readLine());

            int[] days = new int[4];
            for(int j = 0 ; j < days.length ; j++)
                days[j] = Integer.parseInt(st.nextToken());

            if(days[0] == days[2]){
                System.out.println("#" + i + " " + (month[days[0]-1] - days[1] + 1));
                continue;
            }

            int dayNum = (month[days[0]-1] - days[1] + 1) + days[3];
            for(int k = days[0] + 1 ; k < days[2] ; k++){
                dayNum += month[k -1];
            }
            System.out.println("#" + i + " " + dayNum);
        }
        }
    }