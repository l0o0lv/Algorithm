import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1 ; i <= N ; i++){
            q.add(i);
        }

        while(q.size() != 1){
            q.remove();
            q.add(q.remove());
        }

        System.out.println(q.remove());
    }
}