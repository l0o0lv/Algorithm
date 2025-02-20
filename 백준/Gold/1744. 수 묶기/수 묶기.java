import java.util.*;
import java.io.*;

class Main {
    static int answer;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        
        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(br.readLine());
            if(num <= 0){
                negative.add(num);
            } else if(num == 1){
                answer += num;
            } else{
                positive.add(num);
            }
        }

        Collections.sort(positive);
        Collections.sort(negative, Collections.reverseOrder());

        calculate(positive);
        calculate(negative);

        System.out.println(answer);
    }

    static void calculate(List list){
        for(int i = list.size() - 1 ; i > 0 ; i-= 2){
            answer += (int)(list.get(i)) * (int)(list.get(i-1));
        }

        if(list.size() % 2 == 1){
            answer += (int)list.get(0);
        }
    }
}