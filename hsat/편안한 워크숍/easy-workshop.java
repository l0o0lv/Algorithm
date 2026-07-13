import java.util.Scanner;
public class Main {
    static int n, k;
    static int ans;
    static int[][] grid;
    static int[][][] dp;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ans = Integer.MAX_VALUE;
        n = scanner.nextInt();
        k = scanner.nextInt();
        grid = new int[n][n];
        dp = new int[n][n][k + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = scanner.nextInt();
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int l = 0 ; l <= k ; l++){
                    dp[i][j][l] = -1;
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                ans = Math.min(ans, dfs(i, j, k));
            }
        }

        if(ans == Integer.MAX_VALUE){
            System.out.println("-1");
        }
        else{
            System.out.println(ans);
        }
    }

    static int dfs(int x, int y, int l){
        if(dp[x][y][l] != -1){
            return dp[x][y][l];
        }

        if(l == 1){
            return dp[x][y][l] = 0;
        }

        
        int best = Integer.MAX_VALUE; // best를 왜 선언해야 하고 왜 MAX로 초기화하는지
        for(int i = 0 ; i < 4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(grid[nx][ny] > grid[x][y]){
                int diff = grid[nx][ny] - grid[x][y];
                best = Math.min(best, Math.max(diff, dfs(nx, ny, l - 1)));
            }
        }

        return dp[x][y][l] = best; // 왜 얘를 반환해야 하는지, 이렇게 하면 결국 시작점, ex) 1,1,4에 바로 해당 루트에서 갈 수 있는 편안한 루트가 나오는 거 아닌지
    }
}