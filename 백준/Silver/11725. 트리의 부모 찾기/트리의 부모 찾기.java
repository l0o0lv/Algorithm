import java.util.*;
import java.io.*;

class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> list;
    static boolean visited[];
    static int parent[];

    static void dfs(int node){
        visited[node] = true;

        ArrayList<Integer> nextList = list.get(node);
        for(int i = 0 ; i < nextList.size() ; i++){
            int next = nextList.get(i);
            if(!visited[next]){
                parent[next] = node;
                dfs(next);
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        parent = new int[N+1];
        list = new ArrayList<>();

        for(int i = 0 ; i < N + 1; i++) list.add(new ArrayList<>());

        for(int i = 0 ; i < N - 1 ; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(1);

        for(int i = 2; i <= N ; i++){
            System.out.println(parent[i]);
        }
    }
}