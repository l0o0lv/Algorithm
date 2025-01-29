import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int check[] = new int[4];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 비밀번호 길이
        String text = br.readLine(); //문자열
        int count = 0;
        char textArr[] = text.toCharArray();
        int isDNA[] = new int[4];
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < 4 ; i++){
            check[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < P ; i++){
                if(textArr[i] == 'A')
                    isDNA[0]++;
                else if(textArr[i] == 'C')
                    isDNA[1]++;
                else if(textArr[i] == 'G')
                    isDNA[2]++;
                else if(textArr[i] == 'T')
                    isDNA[3]++;
        }

        if(checkDNA(isDNA))
            count++;

        for(int j = P ; j < S ; j++){
            int i = j - P;

            if(textArr[i] == 'A')
                    isDNA[0]--;
                else if(textArr[i] == 'C')
                    isDNA[1]--;
                else if(textArr[i] == 'G')
                    isDNA[2]--;
                else if(textArr[i] == 'T')
                    isDNA[3]--;
            
            if(textArr[j] == 'A')
                    isDNA[0]++;
                else if(textArr[j] == 'C')
                    isDNA[1]++;
                else if(textArr[j] == 'G')
                    isDNA[2]++;
                else if(textArr[j] == 'T')
                    isDNA[3]++;

            if(checkDNA(isDNA))
                count++;
        }
        System.out.println(count);
    }
    
    static boolean checkDNA(int[] isDNA){
        for(int i = 0 ; i < isDNA.length ; i++){
            if(isDNA[i] < check[i]){
                return false;
            }
        }
        return true;
    }
}