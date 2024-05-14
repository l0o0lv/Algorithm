import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        System.out.println(sugar(N));
    }
    static int sugar(int N){
        int bag = 5000;


        for(int i = 0 ; i <= N / 3 ; i++)
            for(int j = 0 ; j <= N / 5 ; j++){
                if(i * 3 + j * 5 == N && bag > i + j){
                    bag = i + j;
                }
            }

        if(bag == 5000)
            return -1;
        return bag;
    }
}