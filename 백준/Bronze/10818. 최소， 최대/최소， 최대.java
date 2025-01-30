import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstNum = Integer.parseInt(st.nextToken()); // 첫 번째 숫자 읽기
        int min = firstNum, max = firstNum; // 최솟값, 최댓값 초기화

        for (int i = 1; i < N; i++) { // 나머지 N-1개의 숫자 처리
            int num = Integer.parseInt(st.nextToken());
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        System.out.println(min + " " + max);
    }
}
