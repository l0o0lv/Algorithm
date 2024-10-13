import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 1 ; i <= num ; i ++)
            answer += i;

        System.out.print(answer);
    }
}