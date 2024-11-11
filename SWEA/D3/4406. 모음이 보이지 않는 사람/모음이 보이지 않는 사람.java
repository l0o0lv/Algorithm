import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= testCase ; i++){
            System.out.print("#" + i + " ");

            String text = br.readLine();

            text = text.replace("a","");
            text = text.replace("e","");
            text = text.replace("i","");
            text = text.replace("o","");
            text = text.replace("u","");

            System.out.println(text);
        }
    }
}