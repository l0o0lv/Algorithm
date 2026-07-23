import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        
        Arrays.sort(a);

        for(int i = 0 ; i < n ; i++){
            hm.put(a[i], i + 1);
        }

        for (int i = 0; i < q; i++){
            int query = sc.nextInt();
            
            if(!hm.containsKey(query)){
                sb.append("0\n");
            }
            else{
                int idx = hm.get(query);
                int answer = (idx - 1) * (n - idx);
                sb.append(answer + "\n");
            }
        }

        System.out.println(sb.toString());
    }
}