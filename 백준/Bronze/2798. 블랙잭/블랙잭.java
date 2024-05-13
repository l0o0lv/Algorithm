import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(search(arr,N,M));
    }
    static int search(int[] arr, int N, int M){
        int result = 0;
        // 카드를 3장 뽑아야 하기 때문에 3중 배열문을 만들어준다.
        for(int i = 0 ; i<N-2 ; i++) // i는 끝까지 가면 안된다. 3장을 무조건 뽑아야 하니 N-2까지
            for(int j = i+1 ; j<N-1 ; j++) // j는 N-1까지
                for(int k = j+1 ; k<N ; k++){ // k는 다 봐도 됨
                    int temp = arr[i] + arr[j] + arr[k]; // 세 카드를 더한 값이

                    if(temp == M) // M과 같으면 temp 리턴
                        return temp;

                    if(result < temp && temp < M) // 더한 값이 result보다 크고 M보다 작으면
                        result = temp; // result에 temp값 대입
                }
        return result;
    }
}