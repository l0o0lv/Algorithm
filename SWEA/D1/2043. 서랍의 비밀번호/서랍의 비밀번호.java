import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int count = 0;

        for(int i = num ; i<= answer ; i++){
            count++;
        }
        System.out.println(count);
    }
}