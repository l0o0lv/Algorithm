import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] score = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D-"};
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 1 ; i <= testCase ; i++){
            st = new StringTokenizer(br.readLine());

            int student = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            List<Double> list = new ArrayList<>();

            for(int j = 0 ; j < student ; j++){
                st = new StringTokenizer(br.readLine());
                double midExam = Integer.parseInt(st.nextToken()) * 35;
                double finalExam = Integer.parseInt(st.nextToken()) * 45;
                double assignment = Integer.parseInt(st.nextToken()) * 20;
                double total = midExam + finalExam + assignment;
                
                list.add(total);
            }

            double findScore = list.get(K - 1);

            Collections.sort(list);
            Collections.reverse(list);

            int location = list.indexOf(findScore) / (student / 10);

            System.out.println("#" + i + " " + score[location]);
        }
    }
}