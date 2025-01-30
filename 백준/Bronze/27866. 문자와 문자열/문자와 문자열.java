import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); // 문자열 입력
        int i = Integer.parseInt(br.readLine()); // 인덱스 입력

        System.out.println(S.charAt(i - 1)); // i번째 문자 출력 (0-based index)
    }
}
