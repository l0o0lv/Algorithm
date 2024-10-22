import java.util.*;
import java.lang.*;
import java.io.*;

class Solution  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        System.out.print("1");
        for(int i = 2 ; i <= number ; i++){
            String numberToStr = String.valueOf(i);
            int count = 0;
            for(int j = 0 ; j < numberToStr.length() ; j++){
                char num = numberToStr.charAt(j);
                if(num == '3' ||
                  num == '6'||
                  num == '9')
                    count++;
            }

            if(count == 0)
                System.out.print(" " + i);
            else{
                System.out.print(" ");
                for(int k = 0 ; k < count ; k++)
                    System.out.print("-");
            }
        }
        }
    }