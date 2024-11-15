import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int i = 1 ; i <=10 ; i++){
            int lengthCondition = Integer.parseInt(br.readLine());
            int count = 0;
            String[][] text = new String[8][8];
            int rangeOfFor = text.length - lengthCondition + 1;

            for(int j = 0 ; j < text.length ; j++){
                String oneLine = br.readLine();
                int oneLineCount = 0;
                for(int k = 0 ; k < text.length ; k++){
                    text[j][k] = Character.toString(oneLine.charAt(oneLineCount));
                    oneLineCount++;
                }
            }
            
            for(int j = 0 ; j < rangeOfFor ; j++){
                for(int k = 0 ; k < text.length ; k++){
                    StringBuilder width = new StringBuilder();
                    for(int l = (j + lengthCondition - 1 ) ; l >= j ; l--){
                        width.append(text[l][k]);
                    }
                    String palindromeText = width.toString();
                    String reversePalindromeText = width.reverse().toString();

                    if(palindromeText.equals(reversePalindromeText)){
                        count++;
                    }
                }
            }
            
            for(int j = 0 ; j < text.length ; j++){
                for(int k = 0 ; k < rangeOfFor ; k++){
                    StringBuilder height = new StringBuilder();
                    for(int l = (k + lengthCondition - 1) ; l >= k ; l--){
                        height.append(text[j][l]);
                    }
                    String palindromeText = height.toString();
                    String reversePalindromeText = height.reverse().toString();

                    if(palindromeText.equals(reversePalindromeText))
                        count++;
                }
            }
            System.out.println("#" + i + " " + count);
        }
    }
}