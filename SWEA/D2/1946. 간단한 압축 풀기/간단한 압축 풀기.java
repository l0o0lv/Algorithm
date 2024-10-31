import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 1 ; i <= testCase ; i++){
            
            int index = 0;
            int fileNum = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            
            for(int j = 0 ; j < fileNum ; j++){
                st = new StringTokenizer(br.readLine());
                String alphabet = st.nextToken();
                int repeatNum = Integer.parseInt(st.nextToken());
                
                for(int k = 0 ; k < repeatNum ; k++)
                    list.add(alphabet);
            }

            System.out.println("#" + i);
            for(int j = 0 ; j < list.size() ; j++){
                System.out.print(list.get(j));
                index++;
                
                if(index == 10){
                    System.out.println("");
                    index = 0;
                }
            }
            System.out.println("");
        }
    }
}