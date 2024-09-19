import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int count = 1;
        int start = 2;
        
        if(num == 1)
            System.out.print(1);
        else{
            while(true){
                if(num >= start){
                    start += (6 * count);
                    count++;
                }
                else{
                    System.out.print(count);
                    break;
                }
            }
        }        
    }
}