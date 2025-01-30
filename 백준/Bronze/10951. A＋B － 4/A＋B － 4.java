import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // int number = Integer.parseInt(br.readLine());
        try {        
            while(true){
            st = new StringTokenizer(br.readLine());

            System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
        }
        } catch (Exception e) {
            
        }
    }
}