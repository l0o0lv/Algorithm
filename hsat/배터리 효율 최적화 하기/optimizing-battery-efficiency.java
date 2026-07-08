import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;

    static List<int[]> current;
    static Set<String> shapeKeys;
    static List<List<String>> shapes;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        current = new ArrayList<>();
        shapeKeys = new HashSet<>();
        shapes = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                visited[i][j] = true;
                current.add(new int[]{i, j});

                dfs(1);

                current.remove(current.size() - 1);
                visited[i][j] = false;
            }
        }

        System.out.println(findMaxBattery());
    }
    
    static void dfs(int depth){
        if(depth == 5){
            saveShape();
            return;
        }

        for(int i = 0 ; i < current.size() ; i++){
            for(int j = 0 ; j < 4 ; j++){
                int nx = current.get(i)[0] + dx[j];
                int ny = current.get(i)[1] + dy[j];

                if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                current.add(new int[]{nx, ny});

                dfs(depth + 1);

                current.remove(current.size() - 1);
                visited[nx][ny] = false;
            }
        }
    }

    static void saveShape(){
        List<String> battery = new ArrayList<>();

        for(int[] now : current){
            battery.add(now[0] + "," + now[1]);
        }

        Collections.sort(battery);

        if(shapeKeys.contains(battery.toString())) return;

        shapeKeys.add(battery.toString());
        shapes.add(battery);
    }
    
    static int findMaxBattery(){
        for(int i = 0 ; i < shapes.size() - 1 ; i++){
            for(int j = i + 1 ; j < shapes.size() ; j++){
                List<String> a = shapes.get(i);
                List<String> b = shapes.get(j);

                int duplCnt = 0;

                for(String battery : b){
                    if(a.contains(battery)) duplCnt++;
                }

                if(duplCnt != 2) continue;

                int score = 0;

                for(int k = 0 ; k < 5 ; k++){
                    String aArr[] = a.get(k).split(",");
                    String bArr[] = b.get(k).split(",");
                    int aX = Integer.parseInt(aArr[0]);
                    int aY = Integer.parseInt(aArr[1]);
                    int bX = Integer.parseInt(bArr[0]);
                    int bY = Integer.parseInt(bArr[1]);
                    score += (board[aX][aY] + board[bX][bY]);
                }

                answer = Math.max(answer, score);
            }
        }
        return answer;
    }
}