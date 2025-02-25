import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int V, E;
    static int firstNode, secondNode;
    static Node[] nodes;
    static ArrayList<Integer> visited;
    static int size;
    static int parent;
    
    public static class Node{
        int parent;
        int left;
        int right;

        public Node(){
            this.parent = 0;
            this.left = 0;
            this.right = 0;
        }
    }
    static void findParent(int node){
        int p = nodes[node].parent;

        if(p == 0 || parent!= 0){
            return;
        }

        if(visited.contains(p)){
            parent = p;
        } else {
            visited.add(p);
        }

        findParent(p);
    }
    static void getSubTreeSize(int root){
        size++;
        
        if(nodes[root].left !=0){
            getSubTreeSize(nodes[root].left);
        }
        
        if(nodes[root].right !=0){
            getSubTreeSize(nodes[root].right);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for(int testCase = 1 ; testCase <= tc ; testCase++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            firstNode = Integer.parseInt(st.nextToken());
            secondNode = Integer.parseInt(st.nextToken());
            nodes = new Node[V+1];
            visited = new ArrayList<>();
            size = 0;
            parent = 0;

            for(int i = 1 ; i <= V ; i++){
                nodes[i] = new Node();
            }
            
            st = new StringTokenizer(br.readLine());
            
            for(int i = 1 ; i <= E ; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(nodes[a].left == 0){
                    nodes[a].left = b;
                } else {
                    nodes[a].right = b;
                }
                nodes[b].parent = a;
            }

            findParent(firstNode);
            findParent(secondNode);

            getSubTreeSize(parent);
            
            System.out.println("#" + testCase + " " + parent + " " + size);
            
            
        }
    }
}