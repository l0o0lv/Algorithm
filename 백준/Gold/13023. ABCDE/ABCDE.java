import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean visited[];
    static ArrayList<Integer>[] friends;
    static boolean answer = false;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        friends = new ArrayList[N];

        for(int i = 0 ; i < N ; i++){
            friends[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a].add(b);
            friends[b].add(a);
            }
        
        for(int i = 0 ; i < N ; i++){
            visited = new boolean[N];
            DFS(i, 0);

            if(answer){
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
        
    }
    static void DFS(int index, int depth){
        if(depth == 4){
            answer = true;
            return;
        }
        visited[index] = true;

        for(int i = 0 ; i <friends[index].size() ; i++){
            int next = friends[index].get(i);
            if(!visited[next]){
                DFS(next, depth +1);
            }
        }
        visited[index] = false;
    }
}