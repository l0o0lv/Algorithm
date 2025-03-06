import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[] arr;
    static int a, b, c;

    static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x == y) return;

        if(x < y) arr[y] = x;
        else arr[x] = y;
    }

    static int find(int a){
        if(arr[a] == a) return a;

        return arr[a] = find(arr[a]);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        for(int i = 1 ; i <= n ; i++){
            arr[i] = i;
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a == 0){
                union(b, c);
            }
            else if(a == 1){
                if(find(b) == find(c)){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}