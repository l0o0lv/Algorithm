import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, hCount, nhCount;
	static int[][] h;        
	static int[][] nh;       
	static int[][] visited1; 
	static int[][] visited2;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		h = new int[N][N];
		nh = new int[N][N];
		visited1 = new int[N][N];
		visited2 = new int[N][N];
		hCount = 0;
		nhCount = 0;

		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < N; j++) {
				char c = line.charAt(j);
				if (c == 'R') {
					h[i][j] = 1;
					nh[i][j] = 1;
				} else if (c == 'G') {
					h[i][j] = 2;
					nh[i][j] = 1; 
				} else if (c == 'B') {
					h[i][j] = 3;
					nh[i][j] = 2;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited1[i][j] == 0) {
					bfs(i, j, h, visited1);
					hCount++;
				}
				if (visited2[i][j] == 0) {
					bfs(i, j, nh, visited2);
					nhCount++;
				}
			}
		}

		System.out.print(hCount + " " + nhCount);
	}

	static void bfs(int x, int y, int[][] map, int[][] visited) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{x, y});
		visited[x][y] = 1;
		int color = map[x][y];

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int cx = now[0];
			int cy = now[1];

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (visited[nx][ny] == 0 && map[nx][ny] == color) {
						visited[nx][ny] = 1;
						queue.add(new int[]{nx, ny});
					}
				}
			}
		}
	}
}
