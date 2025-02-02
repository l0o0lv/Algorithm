import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>((o1,o2) -> {
            if(Math.abs(o1) != Math.abs(o2))
                    return Integer.compare(Math.abs(o1),Math.abs(o2));
            return Integer.compare(o1,o2); 
        });

        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(pQ.isEmpty()){
                    System.out.println("0");
                } else {
                    System.out.println(pQ.poll());
                }
            } else {
                pQ.add(num);
            }
        }
    }
}