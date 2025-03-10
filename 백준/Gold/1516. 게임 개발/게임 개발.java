import java.util.*;
import java.io.*;

class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int N;
    static int[] hour;
    static int[] answer;
    static int[] inDegree;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        hour = new int[N+1];
        answer = new int[N+1];
        inDegree = new int[N+1];
        
        for(int i =  0 ; i < N + 1 ; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());

            hour[i] = Integer.parseInt(st.nextToken());

            while(true){
                int num = Integer.parseInt(st.nextToken());

                if(num == -1) break;

                graph.get(num).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1 ; i <= N ; i++){
            if(inDegree[i] == 0) {
                answer[i] = hour[i];
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();

            ArrayList<Integer> nextGraph = graph.get(now);
            for(int i = 0 ; i < nextGraph.size() ; i++){
                int next = nextGraph.get(i);
                answer[next] = Math.max(answer[next], answer[now] + hour[next]);
                
                if(--inDegree[next] == 0) q.offer(next);
            }
        }

        for(int i = 1 ; i <= N; i++){
            bw.write(answer[i] + "\n");
        }

        bw.flush();
    }
}