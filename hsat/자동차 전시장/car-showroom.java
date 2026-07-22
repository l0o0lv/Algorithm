import java.util.*;
public class Main {
    static List<List<Integer>> map;
    static int[] maxDist;
    static int[] reachCnt;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] startPoints = new int[k];
        map = new ArrayList<>();
        maxDist = new int[n + 1];
        reachCnt = new int[n + 1];
        int answer = Integer.MAX_VALUE;

        for(int i = 0 ; i <= n ; i++){
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            map.get(a).add(b);
        }

        for (int i = 0; i < k; i++) {
            int start = sc.nextInt();
            bfs(start);
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

    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        q.offer(start);

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : map.get(now)){
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