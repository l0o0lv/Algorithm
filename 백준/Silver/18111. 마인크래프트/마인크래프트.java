import java.util.*;
import java.io.*;

class Main {
    static int N, M, B;
    static int[][] map;
    static int minHeight = 256;
    static int maxHeight = 0;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, map[i][j]);
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int answerTime = Integer.MAX_VALUE;
        int answerHeight = 0;

        for(int height = minHeight ; height <= maxHeight ; height++){
            int time = 0;
            int blocks = B;

            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    int diff = map[i][j] - height;

                    if(diff > 0){
                        time += diff * 2;
                        blocks += diff;
                    } else if(diff < 0){
                        time += -(diff);
                        blocks -= -(diff);
                    }
                }
            }

            if(blocks >= 0){
                if(time < answerTime || (time == answerTime && height > answerHeight)){
                    answerTime = time;
                    answerHeight = height;
                }
            }
        }
        System.out.println(answerTime + " " + answerHeight);
    }
}