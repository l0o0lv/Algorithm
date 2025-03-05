import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int maxA, maxB, maxC;
    static ArrayList<Integer> answer;

    static class Bottle{
        int a,b,c;
        public Bottle(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static void bfs(){
        Queue<Bottle> q = new LinkedList<>();
        boolean[][][] visited = new boolean[maxA + 1][maxB + 1][maxC + 1];

        q.add(new Bottle(0,0,maxC)); // init
        while(!q.isEmpty()){
            Bottle now = q.poll();
    
            if(visited[now.a][now.b][now.c]) continue;

            if(now.a == 0) answer.add(now.c);

            visited[now.a][now.b][now.c] = true;

            // B에서A로 물이 갈 때
            if(now.a + now.b <= maxA){
                q.add(new Bottle(now.a + now.b, 0, now.c));
            } else {
                q.add(new Bottle(maxA, now.a + now.b - maxA, now.c));
            }
            // C에서 A로
            if(now.a + now.c <= maxA){
                q.add(new Bottle(now.a + now.c, now.b, 0));
            } else{
                q.add(new Bottle(maxA, now.b, now.a + now.c - maxA));
            }
            // A에서 B로
            if(now.a + now.b <= maxB){
                q.add(new Bottle(0, now.a+ now.b, now.c));
            }else{
                q.add(new Bottle(now.a + now.b - maxB, maxB, now.c));
            }
            // C에서 B로
            if(now.b + now.c <= maxB){
                q.add(new Bottle(now.a, now.b + now.c, 0));
            } else{
                q.add(new Bottle(now.a, maxB, now.b + now.c - maxB));
            }
            // A에서 C로
            if(now.a + now.c <= maxC){
                q.add(new Bottle(0, now.b, now.a + now.c));
            } else{
                q.add(new Bottle(now.a + now.c - maxC, now.b, maxC));
            }
            // B에서 C로
            if(now.b + now.c <= maxC){
                q.add(new Bottle(now.a, 0, now.b + now.c));
            } else {
                q.add(new Bottle(now.a, now.b + now.c - maxC, maxC));
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        maxA = Integer.parseInt(st.nextToken());
        maxB = Integer.parseInt(st.nextToken());
        maxC = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();

        bfs();

        Collections.sort(answer);
        for(int num : answer){
            System.out.print(num + " ");
        }
    }
}