import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] book;
    static int maxPage;

    static void dfs(int index, int day, int page){
        if(day > N) return;

        maxPage = Math.max(maxPage, page);

        for(int next = index ; next < M ; next++){
            dfs(next + 1, day + book[next][0] , page + book[next][1]);
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maxPage = Integer.MIN_VALUE;
        book = new int[M][2];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            book[i][0] = Integer.parseInt(st.nextToken());
            book[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        System.out.println(maxPage);
    }
}