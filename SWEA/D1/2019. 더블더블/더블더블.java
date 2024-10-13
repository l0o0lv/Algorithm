import java.util.*;
import java.lang.*;
import java.io.*;
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int start = 1;
        
        for(int i=0; i<=num ; i++){
            System.out.print(start + " ");
            start *= 2;
        }
    }
}