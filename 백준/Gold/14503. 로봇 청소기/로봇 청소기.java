import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] map;
    static int r, c, d;
    static int answer;
    
    // 방향: 북(0), 동(1), 남(2), 서(3)
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static void cleanRoom() {
        while (true) {
            // 1. 현재 위치 청소
            if (map[r][c] == 0) {
                answer++;
                map[r][c] = 2; // 청소 완료 표시
            }
            
            boolean cleaned = false;
            // 2. 4방향 탐색
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 반시계 방향 회전
                int nextR = r + dx[d];
                int nextC = c + dy[d];
                
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && map[nextR][nextC] == 0) {
                    r = nextR;
                    c = nextC;
                    cleaned = true;
                    break;
                }
            }
            
            // 3. 네 방향 모두 청소할 수 없는 경우 후진
            if (!cleaned) {
                int backR = r - dx[d];
                int backC = c - dy[d];
                
                // 후진할 위치가 벽이면 종료
                if (backR < 0 || backR >= N || backC < 0 || backC >= M || map[backR][backC] == 1) {
                    break;
                }
                
                r = backR;
                c = backC;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        cleanRoom();
        System.out.println(answer);
    }
}