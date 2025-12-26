import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static ArrayList<Integer> list;
    static int k;
    static int answer;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        answer = Integer.MIN_VALUE;
        
        for(int i = 0 ;  i < k ; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        while(!list.isEmpty()){
            answer = Math.max(answer, list.get(0) * k--);
            list.remove(0);
        }

        System.out.println(answer);
    }
}