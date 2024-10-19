import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= testCase ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken()); // A사의 1리터당 P원
            int Q = Integer.parseInt(st.nextToken()); // 기본요금 Q원
            int R = Integer.parseInt(st.nextToken()); // R리터 이하 사용 시 기본요금
            int S = Integer.parseInt(st.nextToken()); // R리터 초과사용 시 1L당 S원
            int W = Integer.parseInt(st.nextToken()); // 사용한 수도량
            
            int priceA = P * W; // A사는 1리터당 P원 * 사용한 수도량
            int priceB = 0;

            if(W <= R) // 기본요금 이하 사용 시
                priceB = Q; // 기본요금
            else //초과 사용 시
                priceB = Q + (S * (W - R)); //기본요금 + (1리터당 S원 * (사용한 수도량 - 기본요금 수도량))

            if(priceA < priceB)
                System.out.println("#" + i + " " + priceA);
            else
                System.out.println("#" + i + " " + priceB);   
        }
    }
}