import java.util.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<>();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);
        
        int[] queries = new int[q];
        for (int i = 0; i < q; i++) queries[i] = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            hm.put(a[i], (i * ((n - 1) - i)));
        }

        for(int i = 0 ; i < q ; i++){
            int query = queries[i];

            sb.append(hm.getOrDefault(query, 0) + "\n");
        }

        System.out.println(sb.toString());
    }
}