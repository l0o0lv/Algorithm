import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = scanner.nextInt();
        }

        int left = 1;
        int right = positions[n-1];
        int answer = Integer.MAX_VALUE;

        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 0;
            int length = 0;

            for(int i = 0 ; i < n ; i++){
                if(length < positions[i]){
                    cnt++;
                    length = (positions[i] + mid) - 1;
                }
            }

            if(cnt > k){
                left = mid + 1;
            }
            else if(cnt <= k){
                answer = Math.min(answer, mid);
                right = mid - 1;
            }
        }

        System.out.println(answer);   
    }
}