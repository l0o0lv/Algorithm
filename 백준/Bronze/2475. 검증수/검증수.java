import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        for(int i = 0 ; i < 5 ; i++){
            answer += Math.pow(Integer.parseInt(st.nextToken()),2);
        }

        System.out.print(answer % 10);
    }
}