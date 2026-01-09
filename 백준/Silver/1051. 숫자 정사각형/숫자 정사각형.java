import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] map;
    static int n, m;
    static int answer = 1;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int minNum = Math.min(n, m);
        
        map = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            String text = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = text.charAt(j) - '0';
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                for(int k = 1 ; k < minNum ; k++){
                    if(i + k >= n || j + k >= m) continue;

                    if(map[i][j] == map[i + k][j]
                       && map[i][j] == map[i][j + k]
                       && map[i][j] == map[i + k][j + k]){
                        answer = Math.max(answer, (k + 1) * (k + 1));
                      }
                }
            }
        }
        System.out.println(answer);
    }
}