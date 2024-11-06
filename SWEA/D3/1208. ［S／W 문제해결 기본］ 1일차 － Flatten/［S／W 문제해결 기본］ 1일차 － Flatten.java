import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = 10;

        for(int i = 1 ; i <=  testCase ; i++){
            System.out.print("#" + i + " ");

            int tryCount = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < 100 ; j++)
                list.add(Integer.parseInt(st.nextToken()));

            for(int k = 0 ; k < tryCount ; k++){
                int max = Collections.max(list);
                int min = Collections.min(list);

                if((max - min) == 0)
                    break;

                list.set(list.indexOf(max), max - 1);
                list.set(list.indexOf(min), min + 1);
            }

            int max = Collections.max(list);
            int min = Collections.min(list);

            int answer = max - min;

            System.out.println(answer);
            
        }
    }
}