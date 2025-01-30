import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());

        if((a % 4 == 0 && !(a % 100 ==0)) || a % 400 ==0)
            System.out.print("1");
        else
            System.out.print("0");
    }
}