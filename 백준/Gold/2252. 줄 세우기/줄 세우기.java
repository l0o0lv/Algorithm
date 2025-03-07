import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i < N + 1 ; i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
            arr[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 1 ; i <= N ; i++){
            if(arr[i] == 0) {
                q.offer(i);
            }
        }
        while(q.size() > 0){
            int now = q.poll();
            answer.add(now);
            List<Integer> list2 = list.get(now);
            
            for(int next = 0 ; next <list2.size() ; next++){
                int nextNum = list2.get(next);

                arr[nextNum]--;
                
                if(arr[nextNum] == 0){
                    q.offer(nextNum);
                }
            }
        }

        Collections.reverse(answer);
        for(int i : answer){
            sb.append(i + " ");
        }

        System.out.println(sb);
        
    }
}