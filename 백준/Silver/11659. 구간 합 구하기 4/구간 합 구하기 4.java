import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        List<Integer> prefixList = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < N ; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        prefixList.add(list.get(0));

        for(int i = 1 ; i < N ; i++){
            int num = prefixList.get(i-1) + list.get(i);
            prefixList.add(num);
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());

            int startNum = Integer.parseInt(st.nextToken()) - 1;
            int finalNum = Integer.parseInt(st.nextToken()) - 1;
            if(startNum == 0){
                System.out.println(prefixList.get(finalNum));
                continue;
            }
            System.out.println(prefixList.get(finalNum) - prefixList.get(startNum-1));
        }
    }
}