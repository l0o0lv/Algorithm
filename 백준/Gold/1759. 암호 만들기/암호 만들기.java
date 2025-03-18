import java.util.*;
import java.io.*;

class Main {
    static int L, C;
    static String[] alphabet;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int index, String text, int jaum, int moum){
        if(text.length() == L && moum >= 1 && jaum >=2){
            sb.append(text + "\n");
            return;
        }

        for(int i = index ; i < C ; i++){
            if(!visited[i]){
                visited[i] = true;
                String letter = alphabet[i];
                if(letter.equals("a") || letter.equals("e") || 
                   letter.equals("i") || letter.equals("o") || letter.equals("u")){
                    dfs(i + 1, text + letter, jaum, moum + 1);
                } else {
                    dfs(i + 1, text + letter, jaum + 1, moum);
                }
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); // 암호 길이
        C = Integer.parseInt(st.nextToken()); // 주어지는 문자 개수
        alphabet = new String[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < C ; i++){
            alphabet[i] = st.nextToken();
        }

        Arrays.sort(alphabet);
        dfs(0, "", 0, 0);
        System.out.println(sb);
            
    }
}