import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 1 ; i <= testCase ; i++){
            int meter = 0;
            int speed = 0;
            int N = Integer.parseInt(br.readLine());

            for(int j = 0 ; j < N ; j++){
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                
                if(command == 1){
                    int accelSpeed = Integer.parseInt(st.nextToken());
                    speed += accelSpeed;
                    meter += speed;
                } 
                else if(command == 2){
                    int breakSpeed = Integer.parseInt(st.nextToken());
                    
                    if(breakSpeed >= speed){
                        speed = 0;
                    } else{
                        speed -= breakSpeed;
                    }
                    meter += speed;
                }
                else if(command == 0){
                    meter += speed;
                }
            }
            System.out.println("#" + i + " " + meter);
        }
    }
}