import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<Node> coreList;
    static int N;
    static int[][] cell;
    static int maxCore;
    static int minWire;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void dfs(int index, int coreCount, int wireCount){
        if(index == coreList.size()){
            if(maxCore < coreCount){
                maxCore = coreCount;
                minWire = wireCount;
            } 
            else if(maxCore == coreCount){
                minWire = Math.min(minWire, wireCount);
            }
            return;
        }

        Node now = coreList.get(index);
        for(int i = 0 ; i < 4 ; i++){
            int nextX = now.x;
            int nextY = now.y;
            int count = 0;
            
            while(true){
                nextX += dx[i];
                nextY += dy[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) break;

                if(cell[nextX][nextY] == 1){
                    count = 0;
                    break;
                }

                count++;
            }

            int fillX = now.x;
            int fillY = now.y;
            
            for(int j = 0 ; j < count ; j++){
                fillX += dx[i];
                fillY += dy[i];
                cell[fillX][fillY] = 1;
            }

            if(count == 0){
                dfs(index + 1, coreCount, wireCount);
            } else{
                dfs(index +1, coreCount + 1, wireCount + count);
            }

            fillX = now.x;
            fillY = now.y;
            for(int j = 0 ; j < count ; j++){
                fillX += dx[i];
                fillY += dy[i];
                cell[fillX][fillY] = 0;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase ; tc++){
            N = Integer.parseInt(br.readLine());
            cell = new int[N][N];
            coreList = new ArrayList<>();
            minWire = Integer.MAX_VALUE;
            maxCore = Integer.MIN_VALUE;

            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j  < N ; j++){
                    int num = Integer.parseInt(st.nextToken());

                    if(num == 1){
                        cell[i][j] = 1;

                        if(i == 0 || j == 0 || i == N-1 || j == N-1) continue;
                        coreList.add(new Node(i,j));
                    }
                }
            }

            dfs(0,0,0);

            System.out.println("#" + tc  + " " + minWire);
        }
    }
}