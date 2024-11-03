import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= testCase ; i++){
            int N = Integer.parseInt(br.readLine());

            System.out.println("#" + i + " "+ (N * N));
        }
    }
}