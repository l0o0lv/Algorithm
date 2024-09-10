import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        double H = Double.parseDouble(st.nextToken());
        double W = Double.parseDouble(st.nextToken());
        double N = Double.parseDouble(st.nextToken());
        double M = Double.parseDouble(st.nextToken());

        int Hnum = (int) Math.ceil((H /(N+1)));
        int Wnum = (int) Math.ceil((W /(M+1)));

        System.out.println(Hnum * Wnum);
}
}