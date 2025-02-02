import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        int sum = 0;

        ArrayList<Integer> prefixList = new ArrayList<>();

        prefixList.add(list.get(0));

        for(int i = 1 ; i < N ; i++){
            prefixList.add(list.get(i) + prefixList.get(i-1));
        }

        for(int i =0 ; i <N ; i++){
            sum+= prefixList.get(i);
        }
        System.out.println(sum);
    }
}