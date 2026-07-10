import java.util.*;

public class Main {
    static class Student{
        int x, y, score;

        public Student(int x, int y, int score){
            this.x = x;
            this.y = y;
            this.score = score;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] scores = new int[3][n];
        int[][] answer = new int[4][n];
        for (int contest = 0; contest < 3; contest++) {
            for (int i = 0; i < n; i++) {
                scores[contest][i] = sc.nextInt();
            }
        }
        
        PriorityQueue<Student> pq = new PriorityQueue<>((a, b) -> b.score - a.score);

        for(int i = 0 ; i < scores.length ; i++){
            for(int j = 0 ; j < n ; j++){
                pq.offer(new Student(i, j, scores[i][j]));
            }
            int rank = 1;
            int temp = 1;
            Student firstStu = pq.poll();
            int prevScore = firstStu.score;
            answer[firstStu.x][firstStu.y] = rank;
            for(int j = 1 ; j < n ; j++){
                Student now = pq.poll();
                if(prevScore == now.score){
                    answer[now.x][now.y] = rank;
                    temp++;
                }
                else{
                    prevScore = now.score;
                    if(temp != 1) {
                        rank += temp;
                        temp = 1;
                    }
                    else rank++;
                    answer[now.x][now.y] = rank;
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            int sum = 0;
            for(int j = 0 ; j < 3 ; j++){
                sum+= scores[j][i];
            }
            pq.offer(new Student(3, i, sum));
        }

        int prev = 0;
        int temp = 1;
        int rank = 1;
        Student first = pq.poll();
        prev = first.score;
        answer[first.x][first.y] = rank;
        while(!pq.isEmpty()){
            Student now = pq.poll();
            if(prev == now.score){
                answer[now.x][now.y] = rank;
                temp++;
            }
            else{
                prev = now.score;
                if(temp != 1) {
                    rank += temp;
                    temp = 1;
                }
                else rank++;
                answer[now.x][now.y] = rank;
            }
        }

        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < scores[0].length ; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}