import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // 오름차순

        int answer = 0;
        for (int i = 0; i < k; i++) {
            answer = Math.max(answer, arr[i] * (k - i));
        }

        System.out.println(answer);
    }
}