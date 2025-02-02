import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] arr = new Node[N];

        for(int index = 0 ; index < N ; index++){
            int value = Integer.parseInt(br.readLine());
            arr[index] = new Node(index , value);
        }

        Arrays.sort(arr);

        int maxNum = 0;

        for(int i = 0 ; i < N ; i++){
            int moveCount = arr[i].index - i;
            maxNum = Math.max(moveCount,maxNum);
        }

        System.out.println(maxNum+1);

    }
    static class Node implements Comparable<Node>{
        int index;
        int value;

        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node n){
            return this.value - n.value;
        }
    }
}