import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        for(int i = 1 ; i <= testCase ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            double answer = 0;
            
            for(int j = 0 ; j < 10 ; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            list.remove(Integer.valueOf(Collections.max(list)));
            list.remove(Integer.valueOf(Collections.min(list)));
            
            for(int k = 0 ; k < 8 ; k++){
                answer += list.get(k);
            }

            System.out.println("#" + i + " " + (Math.round(answer / 8)));
            }
        }
    }