import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, a, b;
    static int answer;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        answer = 0;
        
        while(true){
            answer++;

            a = ++a / 2;
            b = ++b / 2;

            if(a == b) break;
        }

        System.out.println(answer);
    }

}