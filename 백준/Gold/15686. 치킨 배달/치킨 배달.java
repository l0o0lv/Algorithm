import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static ArrayList<Node> home;
    static ArrayList<Node> chicken;
    static int n, m, answer;
    static boolean[] visited;
    
    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = Integer.MAX_VALUE;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                int num = Integer.parseInt(st.nextToken());

                if(num == 1) home.add(new Node(i,j));
                if(num == 2) chicken.add(new Node(i, j));
            }
        }

        visited = new boolean[chicken.size()];
        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int index, int count){
        if(count == m){
            int res = 0;

            for(int i = 0 ; i < home.size() ; i++){
                int temp = Integer.MAX_VALUE;
                Node curHome = home.get(i);
                
                for(int j = 0 ; j < chicken.size() ; j++){
                    if(visited[j]){
                        Node curChicken = chicken.get(j);
                        
                        int dist = Math.abs(curHome.x - curChicken.x) + Math.abs(curHome.y - curChicken.y);
                        temp = Math.min(temp, dist);
                    }
                }
                res += temp;
            }
            answer = Math.min(answer, res);
        }

        for(int i = index ; i < chicken.size() ; i++){
            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }
    }
}