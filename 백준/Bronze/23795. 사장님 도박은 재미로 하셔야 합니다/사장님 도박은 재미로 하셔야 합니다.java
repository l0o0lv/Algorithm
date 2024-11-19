import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();
        int answer = 0;
        
        while(true){
            int number = Integer.parseInt(br.readLine());
            if(number == -1)
                break;
            list.add(number);
        }

        for(int i = 0 ; i < list.size() ; i++){
            answer += list.get(i);
        }

        System.out.print(answer);
    }
}