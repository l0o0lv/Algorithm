import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 1 ; i <= testCase ; i++){
            int listSize = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0 ; j < listSize ; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);

            System.out.print("#" + i);
            for(int num : list){
                System.out.print(" " + num);
            }
            System.out.println("");
        }
    }
}