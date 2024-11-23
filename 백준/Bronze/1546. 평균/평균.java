import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Double> list = new ArrayList<>();
        
        for(int i = 0 ; i < numberCount ; i++){
            list.add(Double.valueOf(st.nextToken()));
        }

        double maxScore = Collections.max(list);
        double avg = 0;

        for(int i = 0 ; i < numberCount ; i++){
            double modifiedScore = (list.get(i) / maxScore) * 100;
            avg += modifiedScore;
        }
        
        System.out.println(avg/numberCount);
    }
}