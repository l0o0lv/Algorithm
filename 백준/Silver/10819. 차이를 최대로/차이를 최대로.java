import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;
    static int[] calculateArr;
    static boolean[] visited;
    static int max;
    
    static void dfs(int index){
        if(index == N){
            max = Math.max(max, calculate());
        }

        for(int i = 0 ; i < N ; i++){
            if(!visited[i]){
                visited[i] = true;
                calculateArr[index] = arr[i];
                dfs(index + 1);
                visited[i]= false;
            }
        }
    }

    static int calculate(){
        int num = 0;
        for(int i = 0 ; i < N - 1 ; i++){
            num += Math.abs(calculateArr[i] - calculateArr[i+1]);
        }
        return num;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        calculateArr = new int[N];
        visited = new boolean[N];
        max = Integer.MIN_VALUE;
        
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
    }
}