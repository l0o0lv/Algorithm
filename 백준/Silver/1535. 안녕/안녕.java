import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] happy;
    static int maxHappy;
    static void dfs(int index, int hp, int value){
        if(hp <= 0) return;

        maxHappy = Math.max(maxHappy, value);

        for(int next = index ; next < N; next++){
            dfs(next + 1, hp - happy[0][next], value + happy[1][next]);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        happy = new int[2][N];
        maxHappy = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < 2 ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                happy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 100, 0);

        System.out.println(maxHappy);
    }
}