import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();
        String text = br.readLine();
        
        for(int i = 0 ; i < text.length(); i++){
            list.add(text.charAt(i) - '0');
        }

        Collections.sort(list,Comparator.reverseOrder());

        for(int i : list){
            System.out.print(i);
        }
    }
}