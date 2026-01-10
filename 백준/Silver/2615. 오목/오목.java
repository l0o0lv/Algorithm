import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] map;
    static int[] dx = {0, 1, 1, 1};
    static int[] dy = {1, 0, 1, -1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[20][20];

        for(int i = 1 ; i < 20 ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j < 20 ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1 ; i < 20 ; i++){
            for(int j = 1 ; j < 20 ; j++){
                if(map[i][j] == 0) continue;

                for(int dir = 0 ; dir < 4 ; dir++){
                    int prevx = i - dx[dir];
                    int prevy = j - dy[dir];

                    if(isValid(prevx, prevy) && map[prevx][prevy] == map[i][j]) continue;

                    int count = 1;

                    int nx = i;
                    int ny = j;
                    
                    while(true){
                        nx += dx[dir];
                        ny += dy[dir];

                        if(!isValid(nx, ny) || map[nx][ny] != map[i][j]) break;
                        count++;
                    }

                    if(count == 5){
                        System.out.println(map[i][j]);
                        if(dir == 3){
                            System.out.println((i + 4) + " " + (j - 4));
                            return;
                        }
                        System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }

        System.out.println("0");
    }

    static boolean isValid(int x, int y){
        return x >= 1 && x < 20 && y >= 1 && y < 20;
    }
}