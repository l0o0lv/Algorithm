import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static Problem[] problems = new Problem[100001];
    static PriorityQueue<Problem> pQHigh;
    static PriorityQueue<Problem> pQLow;
    
    static class Problem {
        int number;
        int difficult;
        
        public Problem(int number, int difficult){
            this.number = number;
            this.difficult = difficult;
        }
    }

    static void recommend(PriorityQueue<Problem> pQ){
        System.out.println(pQ.peek().number);
    }

    static void solved(int number){
        Problem problem = problems[number];
        pQHigh.remove(problem);
        pQLow.remove(problem);
    }

    static void add(int number, int difficult){
        Problem problem = new Problem(number, difficult);
        problems[number] = problem;
        pQHigh.offer(problem);
        pQLow.offer(problem);
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        pQHigh = new PriorityQueue<>((a, b) -> {
            if(a.difficult == b.difficult){
                return b.number - a.number;
            }
            return b.difficult - a.difficult;
        });
        pQLow = new PriorityQueue<>((a, b) -> {
           if(a.difficult == b.difficult){
               return a.number - b.number;
           }
            return a.difficult - b.difficult;
        });

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int difficult = Integer.parseInt(st.nextToken());
            add(number, difficult);
        }

        M = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());

            String operator = st.nextToken();
            if(operator.equals("add")){
                int number = Integer.parseInt(st.nextToken());
                int difficult = Integer.parseInt(st.nextToken());
                add(number, difficult);
            }
            else if(operator.equals("solved")){
                int number = Integer.parseInt(st.nextToken());
                solved(number);
            }
            else if(operator.equals("recommend")){
                int choice = Integer.parseInt(st.nextToken());
                if(choice == 1){
                    recommend(pQHigh);
                }
                else if(choice == -1){
                    recommend(pQLow);
                }
            }
        }
    }
}