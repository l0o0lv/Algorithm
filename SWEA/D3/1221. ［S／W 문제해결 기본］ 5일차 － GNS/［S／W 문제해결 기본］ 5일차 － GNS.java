import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc <= testCase ; tc++){
            int[] arr = new int[10];
            st = new StringTokenizer(br.readLine());

            String text = st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++){
                String num = st.nextToken();

                if(num.equals("ZRO")){
                    arr[0]++;
                } else if(num.equals("ONE")){
                    arr[1]++;
                } else if(num.equals("TWO")){
                    arr[2]++;
                } else if(num.equals("THR")){
                    arr[3]++;
                } else if(num.equals("FOR")){
                    arr[4]++;
                } else if(num.equals("FIV")){
                    arr[5]++;
                } else if(num.equals("SIX")){
                    arr[6]++;
                } else if(num.equals("SVN")){
                    arr[7]++;
                } else if(num.equals("EGT")){
                    arr[8]++;
                } else if(num.equals("NIN")){
                    arr[9]++;
                }
            }

            int count = 0;
            bw.write(text + "\n");
            while(true){
                if(count == 10) break;

                for(int i = 0 ; i < arr[count] ; i++){
                    if(count == 0){
                        bw.write("ZRO ");
                    } else if(count == 1){
                        bw.write("ONE ");
                    } else if(count == 2){
                        bw.write("TWO ");
                    } else if(count == 3){
                        bw.write("THR ");
                    } else if(count == 4){
                        bw.write("FOR ");
                    } else if(count == 5){
                        bw.write("FIV ");
                    } else if(count == 6){
                        bw.write("SIX ");
                    } else if(count == 7){
                        bw.write("SVN ");
                    } else if(count == 8){
                        bw.write("EGT ");
                    } else if(count == 9){
                        bw.write("NIN ");
                    }
                }
                count++;
            }
            bw.write("\n");
        }
        bw.flush();
    }
}