import java.util.*;
import java.io.*;

class Main {
    static int N;
    static boolean[] selected;
    static int[] peoples;
    static ArrayList<ArrayList<Integer>> graph;
    static int answer;

    static void divide(int index){
        if(index > N){
            checkConnect();
            return;
        }

        selected[index] = true; // A 구역으로 넣기
        divide(index + 1);
        selected[index] = false; // B 구역으로 넣기
        divide(index + 1);
    }

    static void checkConnect(){
        List<Integer> groupA = new ArrayList<>();
        List<Integer> groupB = new ArrayList<>();

        for(int i = 1 ; i <= N ; i++){
            if(selected[i]) groupA.add(i);
            else groupB.add(i);
        }

        if(groupA.isEmpty() || groupB.isEmpty()) return;

        if(isConnect(groupA) && isConnect(groupB)){
            int sumA = 0;
            int sumB = 0;
            for(int num : groupA){
                sumA += peoples[num];
            }
            
            for(int num : groupB){
                sumB += peoples[num];
            }

            answer = Math.min(answer, Math.abs(sumA - sumB));
        }
    }

    static boolean isConnect(List<Integer> group){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.offer(group.get(0));
        visited[group.get(0)] = true;
        int count = 1;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : graph.get(now)){
                if(!visited[next] && group.contains(next)){
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }
        return count == group.size();
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        peoples = new int[N + 1];
        selected = new boolean[N + 1];
        answer = Integer.MAX_VALUE;
        graph = new ArrayList<>();
        
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            int nearCount = Integer.parseInt(st.nextToken());
            
            for(int j = 0 ; j < nearCount ; j++){
                int near = Integer.parseInt(st.nextToken());
                graph.get(i).add(near);
            }
        }

        divide(1);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        
    }
}