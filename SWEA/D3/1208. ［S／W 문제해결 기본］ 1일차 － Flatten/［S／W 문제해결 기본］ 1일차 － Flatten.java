import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        for(int testCase = 1 ; testCase <= 10 ; testCase++){
            int maxFlattenNum = Integer.parseInt(br.readLine()); //평탄화 횟수
            st = new StringTokenizer(br.readLine());
            
            ArrayList<Integer> list = new ArrayList<>();

            for(int index = 0 ; index < 100 ; index++){
                list.add(Integer.parseInt(st.nextToken()));
            }

            for(int doFlatten = 0 ; doFlatten < maxFlattenNum ; doFlatten++){
                int maxIndex = list.indexOf(Collections.max(list));
                int minIndex = list.indexOf(Collections.min(list));
                int flattenMaxNum = list.get(maxIndex) - 1;
                int flattenMinNum = list.get(minIndex) + 1;
                
                list.set(maxIndex, flattenMaxNum);
                list.set(minIndex, flattenMinNum);

                if(flattenMaxNum - flattenMinNum == 0)
                    break;
            }

            int answer = Collections.max(list) - Collections.min(list);
            System.out.println("#" + testCase + " " + answer);
        }
    }
}