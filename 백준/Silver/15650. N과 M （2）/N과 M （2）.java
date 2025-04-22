import java.util.Scanner;

public class Main {
	static int N,M;
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[M];
		visited = new boolean[N+1];
		back(1,0);
		
		System.out.println(sb.toString());
		
	}
	private static void back(int start,int depth) {
		if(depth==M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=start; i<=N; i++) {
			arr[depth] = i;
			back(i+1, depth+1);
			
		}
	}
}
