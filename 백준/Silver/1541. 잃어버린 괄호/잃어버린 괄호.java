import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(),"-"); // -를 기준으로 분리

        int answer = Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            int temp = 0;

            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+"); // -를 기준으로 분리한 st를 +로 재분리
            
            while(st2.hasMoreTokens()){
                temp += Integer.parseInt(st2.nextToken());
            }

            if(answer == Integer.MAX_VALUE){ //더한 값이 첫번째 값이면
                answer = temp;
            } else { //두 번째부터는 빼줘야 함. -로 분리한 것이니.
                answer -= temp;
            }
        }
        System.out.println(answer);
    }
}