import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        String[] day = {"MON","TUE","WED","THU","FRI","SAT","SUN"};

        for(int i = 1 ; i <= testCase ; i++){
            System.out.print("#" + i + " ");

            String getDay = br.readLine();
            int daynum = Arrays.asList(day).indexOf(getDay);

            if(daynum == 6){
                System.out.println("7");
                continue;
            }
            System.out.println((7 - (daynum + 1)));
        }
    }
}