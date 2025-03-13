import java.util.*;
import java.io.*;

class Main {
    static int N, deleteNum;
    static ArrayList<ArrayList<Integer>> graph;
    static int count;
    static int rootNode;
    static boolean[] visited;
    
    // 특정 노드를 삭제하면 해당 노드와 모든 자손을 제거
    static void deleteSubtree(int index) {
        if (index == -1) return;
        
        for (int child : graph.get(index)) {
            deleteSubtree(child);
        }
        
        graph.get(index).clear(); // 현재 노드의 자식 목록 제거
    }
    
    // 리프 노드 개수 찾기
    static void findLeaf(int index) {
        visited[index] = true;

        // 삭제된 노드는 탐색하지 않음
        if (index == deleteNum) return;

        // 자식이 없는 경우 리프 노드로 판별
        boolean isLeaf = true;
        for (int next : graph.get(index)) {
            if (!visited[next] && next != deleteNum) {
                findLeaf(next);
                isLeaf = false;
            }
        }

        if (isLeaf) count++;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>(N);
        count = 0;
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == -1) {
                rootNode = i;
                continue;
            }

            graph.get(num).add(i);
        }

        deleteNum = Integer.parseInt(br.readLine());

        // 삭제할 노드의 자식들도 모두 삭제해야 함
        deleteSubtree(deleteNum);

        // 부모 노드에서 삭제된 노드를 제거
        for (int i = 0; i < N; i++) {
            graph.get(i).remove(Integer.valueOf(deleteNum));
        }

        // 루트 노드가 삭제된 경우 0 출력
        if (rootNode == deleteNum) {
            System.out.println("0");
        } else {
            findLeaf(rootNode);
            System.out.println(count);
        }
    }
}
