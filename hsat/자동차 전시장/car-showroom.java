import java.util.Scanner;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> node;
    static int n, m, k;
    static int[] maxDist;
    static int[] reachCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        int answer = Integer.MAX_VALUE;
        maxDist = new int[n + 1];
        reachCnt = new int[n+ 1];
        node = new ArrayList<>();

        for(int i = 0 ; i <= n ; i++){
            node.add(new ArrayList<>()); 
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            node.get(a).add(b);
        }

        int[] startPoints = new int[k];
        for (int i = 0; i < k; i++) {
            startPoints[i] = sc.nextInt();
        }

        for(int i =  0 ; i < k ; i++){
            bfs(startPoints[i]);
        }

        for(int i = 1 ; i <= n ; i++){
            if(reachCnt[i] == k){
                answer = Math.min(answer, maxDist[i]);
            }
        }

        if(answer == Integer.MAX_VALUE){
            System.out.println("-1");
        }
        else{
            System.out.println(answer);
        }
    }

    static void bfs(int idx){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(idx);
        int[] dist = new int[n + 1];

        Arrays.fill(dist, -1);
        dist[idx] = 0;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : node.get(now)){
                if(dist[next] == -1){
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }

        for(int i = 1 ; i <= n ; i++){
            if(dist[i] != -1){
                maxDist[i] = Math.max(maxDist[i], dist[i]);
                reachCnt[i]++;
            }
        }
    }
}