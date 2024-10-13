import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int num = 0;

        for(int i = 0 ; i <str.length() ; i++){
            int a = str.charAt(i) - '0';
            num += a;
        }
        
        System.out.print(num);
    }
}