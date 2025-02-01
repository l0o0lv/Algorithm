import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        Stack<Integer> myStack = new Stack<>();
        int[] answer = new int[N];
        
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        myStack.push(0);
        for(int i = 1 ; i < N ; i++){
            while(!myStack.isEmpty() && arr[myStack.peek()] < arr[i]){
                answer[myStack.pop()] = arr[i];
            }
            myStack.push(i);
        }
        while(!myStack.isEmpty()){
            answer[myStack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0 ; i < N ; i++){
            bw.write(answer[i] +" ");
        }

        bw.write("\n");
        bw.flush();
    }
}