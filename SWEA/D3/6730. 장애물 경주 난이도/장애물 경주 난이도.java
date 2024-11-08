import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 1 ; i <= testCase ; i++){
            System.out.print("#" + i + " ");

            int listSize = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0 ; j < listSize ; j++)
                list.add(Integer.parseInt(st.nextToken()));

            int up = 0;
            int down = 0;

            for(int j = 0 ; j < listSize - 1 ; j++){
                int a = list.get(j);
                int b = list.get(j+1);
                
                if(a>b)
                    down = Math.max(down,a-b);
                else if(a<b)
                    up = Math.max(up,b-a);
            }            
            System.out.println(up + " " + down);
        }
    }
}