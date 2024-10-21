import java.util.*;
import java.lang.*;
import java.io.*;

class Solution  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= testCase ; i++){
            String text = br.readLine();
            StringBuilder sb = new StringBuilder(text);
            String reverseText = sb.reverse().toString();
            int isSame = 0;
            
            if(text.equals(reverseText))
                isSame = 1;
                
                System.out.println("#" + i + " " + isSame);
        }
        }
    }