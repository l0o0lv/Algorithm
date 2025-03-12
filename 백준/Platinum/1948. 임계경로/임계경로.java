import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int start, end;
    static int meetTime, roadCount;
    static ArrayList<ArrayList<Node>> road, reverseRoad;
    static boolean[] visited;
    static int[] maxTime, inDegree;
    
    static class Node{
        int go, time; //도착 도시, 소요 시간
        public Node(int go, int time){
            this.go = go;
            this.time = time;
        }
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int now = q.poll();

            for(Node next : road.get(now)){
                int nextGo = next.go;
                int nextTime = next.time;

                if(maxTime[now] + nextTime > maxTime[nextGo]){
                    maxTime[nextGo] = maxTime[now] + nextTime;
                }

                if(--inDegree[nextGo] == 0){
                    q.offer(nextGo);
                }
            }
        }
        meetTime = maxTime[end];
    }

    static void reverseBfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(end);

        while(!q.isEmpty()){
            int now = q.poll();

            for(Node prev : reverseRoad.get(now)){
                int prevGo = prev.go;
                int prevTime = prev.time;

                if(maxTime[prevGo] + prevTime == maxTime[now]){
                    roadCount++;
                    if(!visited[prevGo]){
                        visited[prevGo] = true;
                        q.offer(prevGo);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        meetTime = 0;
        roadCount = 0;
        road = new ArrayList<>();
        reverseRoad = new ArrayList<>();
        visited = new boolean[N + 1];
        maxTime = new int[N + 1];
        inDegree = new int[N + 1];

        for(int i = 0 ; i < N + 1 ; i++){
            road.add(new ArrayList<>());
            reverseRoad.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()); //출발 도시
            int v = Integer.parseInt(st.nextToken()); //도착 도시
            int w = Integer.parseInt(st.nextToken()); //소요 시간

            road.get(u).add(new Node(v,w));
            reverseRoad.get(v).add(new Node(u,w));
            inDegree[v]++;
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        bfs();
        reverseBfs();
        
        System.out.println(meetTime);
        System.out.println(roadCount);
    }
}