import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static Node[] nodes;
    static int sum;
    static Stack<Integer> stack;
    
    static class Node{
        String operator;
        int data;
        int left;
        int right;

        public Node(){
            this.operator = null;
            this.data = 0;
            this.left = 0;
            this.right = 0;
        }
    }

    static void calculate(int node){
        if(nodes[node].data != 0){
            stack.push(nodes[node].data);
        }

        if(nodes[node].left != 0){
            calculate(nodes[node].left);
        }

        if(nodes[node].right != 0){
            calculate(nodes[node].right);
        }

        String op = nodes[node].operator;
        if(op != null){
            int a = stack.pop();
            int b = stack.pop();
            if(op.equals("+")){
                sum = b + a;
            } else if(op.equals("-")){
                sum = b - a;
            } else if(op.equals("/")){
                sum =  b / a;
            } else if(op.equals("*")){
                sum = b * a;
            }
            stack.push(sum);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc = 1 ; tc <= 10 ; tc++){
            N = Integer.parseInt(br.readLine());
            nodes = new Node[N+1];
            stack = new Stack<>();
            
            for(int i = 1 ; i <= N ; i++){
                nodes[i] = new Node();
            }

            for(int i = 1 ; i <= N ; i++){
                String[] text = br.readLine().split(" ");

                if(text.length == 4){
                    int index = Integer.parseInt(text[0]);
                    String operator = text[1];
                    int left = Integer.parseInt(text[2]);
                    int right = Integer.parseInt(text[3]);

                    nodes[index].operator = operator;
                    nodes[index].left = left;
                    nodes[index].right = right;
                } else{
                    int index = Integer.parseInt(text[0]);
                    int data = Integer.parseInt(text[1]);

                    nodes[index].data = data;
                }
            }

            calculate(1);

            System.out.println("#" + tc + " " + sum);
        }
    }
}