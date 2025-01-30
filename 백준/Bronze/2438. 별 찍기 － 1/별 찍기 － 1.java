import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= a ; i++){
            for(int j = 0 ; j < i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}