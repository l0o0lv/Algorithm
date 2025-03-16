import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] ingredient;
    static int minFood;

    static void dfs(int index, int S, int B, int count){
        if(count > 0){
            int value = Math.abs(S - B);
            minFood = Math.min(value, minFood);
        }

        for(int next = index ; next < N ; next++){
            dfs(next + 1, S * ingredient[next][0], B + ingredient[next][1], count + 1);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        ingredient = new int[N][2];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }

        minFood = Integer.MAX_VALUE;
        dfs(0, 1, 0, 0);

        System.out.println(minFood);
        
    }
}