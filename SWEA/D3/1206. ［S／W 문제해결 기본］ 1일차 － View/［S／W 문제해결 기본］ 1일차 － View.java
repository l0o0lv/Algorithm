import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;

        for(int testCase = 1 ; testCase <= 10 ; testCase++){
            int building = Integer.parseInt(br.readLine()); // 빌딩 수
            st = new StringTokenizer(br.readLine());

            ArrayList<Integer> list = new ArrayList<>();

            for(int i = 0 ; i < building ; i++){ 
                list.add(Integer.parseInt(st.nextToken()));
            }
            int answer = 0;

            for(int i = 2 ; i < (building - 2) ; i++){
                int leftMax = Math.max(list.get(i-1), list.get(i-2));
                int rightMax = Math.max(list.get(i+1), list.get(i+2));
                int num = Math.max(leftMax,rightMax);

                if(list.get(i) > num){
                answer += list.get(i) - num;
                }
            }

            System.out.println("#" + testCase + " " + answer);
            }
        }
    }