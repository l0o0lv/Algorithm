import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= testCase ; i++){
            System.out.print("#" + i + " ");

            int N = Integer.parseInt(br.readLine());

            for(int j = 1 ; j <= N ; j++){
                System.out.print("1/" + N + " ");
            }

            System.out.println();
        }
    }
}