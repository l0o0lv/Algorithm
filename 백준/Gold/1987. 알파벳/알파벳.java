import java.util.*;
import java.io.*;

class Main {
    static int R, C;
    static char[][] alphabet;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static HashSet<Character> visited;
    static int maxCount;

    static void dfs(int x, int y, int count){

        maxCount = Math.max(maxCount, count);
        for(int i = 0 ; i < 4 ; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
            if(!visited.add(alphabet[nextX][nextY])) continue;

            dfs(nextX, nextY, count + 1);
            visited.remove(alphabet[nextX][nextY]);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new HashSet<>();
        alphabet = new char[R][C];
        maxCount = 0;
        
        for(int i = 0 ; i < R ; i++){
            String text = br.readLine();
            for(int j = 0 ; j < C ; j++){
                alphabet[i][j] = text.charAt(j);
            }
        }

        visited.add(alphabet[0][0]);
        dfs(0, 0, 1);
        System.out.println(maxCount);
    }
}