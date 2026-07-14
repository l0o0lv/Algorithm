import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Long, Integer> hm = new HashMap<>();

        String num = br.readLine();
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long p = 0;

        for(int i = 0 ; i < k ; i++){
            p = (p * 2) + num.charAt(i) - '0';
        }

        hm.put(p, 1);
        
        for(int i = k ; i < num.length() ; i++){
            p = (p * 2) + num.charAt(i) - '0';
            p = p - ((num.charAt(i - k) - '0') * (1L << k));

            hm.put(p, hm.getOrDefault(p, 0) + 1);

            if(hm.get(p) >= m){
                System.out.println("1");
                return;
            }
        }

        System.out.println("0");
    }
}