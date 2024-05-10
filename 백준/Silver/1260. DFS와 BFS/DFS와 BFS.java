import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력 받아오기

        StringTokenizer st = new StringTokenizer(br.readLine()); // 값 받기위한 StringTokenizer

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken()); // 탐색 시작 정점 번호

        A = new ArrayList[N+1]; // 받아온 N개의 컴퓨터 ArrayList 배열 초기화

        for(int i=0 ; i<N+1 ;i++)
            A[i] = new ArrayList<>(); // N개의 컴퓨터 ArrayList 초기화

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }
        for(int i = 0 ; i<N+1 ; i++)
            Collections.sort(A[i]);

        visited = new boolean[N+1];
        StringBuilder sb = new StringBuilder();
        DFS(V);
        for(int i = 0 ; i<N+1 ; i++)
            visited[i] = false;
        BFS(V);

    }
    public static void BFS(int now){
        System.out.print("\n");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(now);
        visited[now] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");
            for(int x : A[node])
                if(!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
        }
    }
    public static void DFS(int now){
        if(visited[now])
            return;
        visited[now] = true;
        System.out.print(now + " ");
        for(int x : A[now])
            if(!visited[x]) {
                DFS(x);
            }
    }
}