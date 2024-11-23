import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberCount = Integer.parseInt(br.readLine());
        String number = br.readLine();
        int answer = 0;
        
        for(int i = 0 ; i < numberCount ; i ++){
            answer += number.charAt(i) - '0';
        }

        System.out.println(answer);
    }
}