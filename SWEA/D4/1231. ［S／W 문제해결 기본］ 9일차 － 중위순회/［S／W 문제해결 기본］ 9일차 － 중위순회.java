import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int N;
    static Node[] nodes;
    
    static class Node{
        String word;
        int left;
        int right;

        public Node(){
            this.word = word;
            this.left = left;
            this.right = right;
        }
    }

    static void inorder(int index){
        if(nodes[index].left != 0){
            inorder(nodes[index].left);
        }
        System.out.print(nodes[index].word);

        if(nodes[index].right != 0){
            inorder(nodes[index].right);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int tc = 1 ; tc <= 10 ; tc++){
            N = Integer.parseInt(br.readLine());

            nodes = new Node[N+1];

            for(int i = 1 ; i <= N; i++){
                nodes[i] = new Node();
            }

            for(int i = 1 ; i <= N ; i++){
                String[] text = br.readLine().split(" ");

                String word = text[1];
                if(text.length == 4){
                    int left = Integer.parseInt(text[2]);
                    int right = Integer.parseInt(text[3]);

                    nodes[i].word = word;
                    nodes[i].left = left;
                    nodes[i].right = right;
                } else if(text.length == 3){
                    int left = Integer.parseInt(text[2]);

                    nodes[i].word = word;
                    nodes[i].left = left;
                } 
                else{
                    nodes[i].word = word;
                }
            }
            System.out.print("#" + tc + " ");
            inorder(1);
            System.out.println();
            
        }
        
    }
}