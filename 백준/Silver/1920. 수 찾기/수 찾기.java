import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++)
            list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);
        
        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer> list2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < M ; i++)
            list2.add(Integer.parseInt(st.nextToken()));

        for(int i = 0 ;  i < M ; i++){
            int mid;
            int low = 0;
            int high = list.size() - 1;
            int key = list2.get(i);

            while(low <= high){
            mid = (low+high) / 2;

            if(list.get(mid) == key){
                System.out.println("1");
                break;
            } else if(key < list.get(mid)){
                high = mid -1;
            } else if(key > list.get(mid)){
                low = mid +1;
            }
        }
            if(low>high){
                System.out.println("0");
            }
        }
    }
}