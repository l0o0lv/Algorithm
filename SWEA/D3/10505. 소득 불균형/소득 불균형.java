import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 1 ; i <= testCase ; i++){
            int people = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();

            for(int j = 0 ; j < people ; j++ ){
                list.add(Integer.parseInt(st.nextToken()));
            }

            int average = 0;
            for(int num : list)
                average += num;

            average /= people;

            int count = 0;

            for(int num : list)
                if(num <= average)
                    count++;

            System.out.println("#" + i + " " + count);
        }
    }
}
