import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] wordArr = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
        List<String> wordList = new ArrayList<>(Arrays.asList(wordArr));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 1 ; i <= testCase ; i++){
            st = new StringTokenizer(br.readLine());

            String attemptNumber = st.nextToken();
            System.out.println(attemptNumber);
        
            int wordCount = Integer.parseInt(st.nextToken());
            List<Integer> wordToNumber = new ArrayList<>();
            
            st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < wordCount ; j++){
                wordToNumber.add(wordList.indexOf(st.nextToken()));
            }

            Collections.sort(wordToNumber);

            for(int j = 0 ; j < wordCount ; j++){
                System.out.print(wordList.get(wordToNumber.get(j)) + " ");
            }

        }
    }
}