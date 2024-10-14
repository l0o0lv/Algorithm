import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine()); // 테스트케이스 갯수

        for(int i = 1 ; i <= testCase ; i++){
            
            int n = Integer.parseInt(br.readLine()); // 예측한 날짜 일수
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>(); // 예측가를 담을 배열
            
            for(int j = 0 ; j < n; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            
            long benefit = 0; // 이윤
            int max = list.get(n-1); // 배열의 끝에서부터 시작하기 위해해
            
            for(int k = n-2 ; k >= 0 ; k--){
                if(list.get(k) > max){ // max 보다 큰 값이 나오면
                    max = list.get(k); // max 값 수정
                }
                else{ // 아니라면
                    benefit += (max - list.get(k)); // benefit에 max 에서 예측가를 뺀 값 더하기
                }
            }
                System.out.println("#" + i + " " + benefit);
        }
    }
}