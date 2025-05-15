import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] number;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        number = new int[N + 1];
        ArrayList<Integer> list = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N ; i > 0 ; i--){
            list.add(number[i], i);
        }
        
        for(int i : list){
            System.out.print(i + " "); 
        }
    }
}