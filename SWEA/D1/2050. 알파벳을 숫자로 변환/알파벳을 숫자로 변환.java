import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] charNum = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        for(int i=0; i<str.length() ; i++){
        for(int j=0; j<charNum.length ; j++){
            if(str.charAt(i) == charNum[j])
                System.out.print((j+1) + " ");
        }
        }
    }
}