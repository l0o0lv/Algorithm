import java.util.Scanner;

public class Main {
    static int n, m, answer;
    static boolean[][] visited;
    static int[][] grid;
    static int[][] targets;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        answer = 0;

        visited = new boolean[n + 1][n + 1];
        grid = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                grid[i][j] = sc.nextInt();
        
        targets = new int[m][2];
        for (int i = 0; i < m; i++) {
            targets[i][0] = sc.nextInt();
            targets[i][1] = sc.nextInt();
        }
        
        visited[targets[0][0]][targets[0][1]] = true;
        dfs(targets[0][0], targets[0][1], 1);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int idx){
        if(idx == m){
            answer++;
            return;
        }

        for(int i = 0 ; i < 4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx > n || nx < 1 || ny > n || ny < 1) continue;

            if(grid[nx][ny] == 0 && !visited[nx][ny]){
                visited[nx][ny] = true;
                if(nx == targets[idx][0] && ny == targets[idx][1]){
                    dfs(nx, ny, idx + 1);
                }
                else{
                    dfs(nx, ny, idx);
                }
                visited[nx][ny] = false;
            }
        }
    }
}