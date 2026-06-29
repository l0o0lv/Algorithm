import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int answer = Integer.MAX_VALUE;

        int[] positions = new int[N];
        for (int i = 0; i < N; i++) {
            positions[i] = scanner.nextInt();
        }

        int left = 1;
        int right = positions[N-1];

        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 0;
            int length = 0;

            for(int i = 0 ; i < positions.length ; i++){
                if(positions[i] > length){
                    cnt++;
                    length = positions[i] + mid - 1;
                }
            }
            if(cnt > K){
                left = mid + 1;
            }
            else if(cnt <= K){
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        System.out.println(answer);
    }
}