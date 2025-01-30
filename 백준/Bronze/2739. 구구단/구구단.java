import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= 9 ; i++){
            System.out.println(number + " * " + i + " = " + number * i);
        }

    }
}