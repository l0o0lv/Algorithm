import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력 받아오기

        int N = Integer.parseInt(br.readLine());

        A = new ArrayList[N+1]; // 받아온 N개의 컴퓨터 ArrayList 배열 초기화

        for(int i=0 ; i<N+1 ;i++)
            A[i] = new ArrayList<>(); // N개의 컴퓨터 ArrayList 초기화

        int M = Integer.parseInt(br.readLine()); // 연결되어 있는 쌍의 수

        StringTokenizer st; // 값 받기위한 StringTokenizer

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }
        visited = new boolean[N+1];
        BFS(1);
        int count = -1;
        for(int i = 0 ; i < N + 1; i++)
            if(visited[i])
                count++;

        System.out.print(count);
    }
    public static void BFS(int now){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(now);
        visited[now] = true;

        while(!queue.isEmpty()){

            int node = queue.poll();

            for(int x : A[node])
                if(!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
        }
    }
}