import java.util.*;
import java.io.*;

class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int N, count;
    static int deleteNode, rootNode;

    static void findLeaf(int index){

        if(graph.get(index).contains(deleteNode)){
            graph.get(index).remove(Integer.valueOf(deleteNode));
        }
        
        if(graph.get(index).isEmpty()){
            count++;
        }

        for(int next : graph.get(index)){
            findLeaf(next);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        count = 0;

        for(int i = 0 ; i < N ; i++){
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(st.nextToken());

            if(num == -1){
                rootNode = i;
                continue;
            }

            graph.get(num).add(i);
        }
        deleteNode = Integer.parseInt(br.readLine());

        if(rootNode == deleteNode) {
            System.out.println("0");
        } else {
            findLeaf(rootNode);
            System.out.println(count);
        }
    }
}