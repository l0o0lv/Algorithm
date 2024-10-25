import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= testCase ; i++){
            int N = Integer.parseInt(br.readLine());
            int k = 0;
            List<Character> list = new ArrayList<>();
            
            while(list.size() != 10){
                k++;
                String nToText = String.valueOf(N * k);
                for(int j = 0 ; j < nToText.length() ; j++){
                    if(!list.contains(nToText.charAt(j))){
                        list.add(nToText.charAt(j));
                    }
                }
            }
            System.out.println("#" + i + " " + (k * N));
        }
    }
}