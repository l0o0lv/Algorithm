import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int findNum = Integer.parseInt(br.readLine());
        int count = 0;
        
        for(int i = 0 ; i < N ; i ++){
            if(list.get(i) == findNum)
                count++;
        }

        System.out.println(count);
    }
}