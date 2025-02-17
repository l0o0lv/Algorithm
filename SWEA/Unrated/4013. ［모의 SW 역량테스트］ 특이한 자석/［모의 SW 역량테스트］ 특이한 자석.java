import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int gear[][];
    static int rotate[];
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int testCase = Integer.parseInt(br.readLine());

        for(int tryCount = 1 ; tryCount <= testCase ; tryCount++){
            int K = Integer.parseInt(br.readLine());

            gear = new int[4][8];
            for(int i = 0 ; i < gear.length ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < gear[i].length ; j++){
                    gear[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            while(K-- > 0){
            rotate = new int[4];
            st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int turn = Integer.parseInt(st.nextToken());
            rotate[gearNum] = turn;

            checkDir(gearNum);
            rotateGear();
            }
            
            int answer =0;
            if(gear[0][0] ==  1) answer += 1;
            if(gear[1][0] ==  1) answer += 2;
            if(gear[2][0] ==  1) answer += 4;
            if(gear[3][0] ==  1) answer += 8;

            System.out.println("#" + tryCount + " " + answer);
        }
        }

    static void checkDir(int gearNum){
        for(int i = gearNum - 1 ; i >=0 ; i--){
            if(gear[i][2] != gear[i+1][6]){
                rotate[i] = -rotate[i+1];
            } else {
                break;
            }
        }

        for(int i = gearNum + 1 ; i < 4 ; i++){
            if(gear[i][6] != gear[i-1][2]){
                rotate[i] = -rotate[i-1];
            } else{
                break;
            }
        }
    }

    static void rotateGear(){
        for(int i = 0 ; i < 4 ; i++){
            if(rotate[i] == 1){
                int temp = gear[i][7];
                for(int j = 7 ; j > 0 ; j--){
                    gear[i][j] = gear[i][j-1];
                }
                gear[i][0] = temp;
            } else if(rotate[i] == -1){
                int temp = gear[i][0];
                for(int j = 0 ; j < 7 ; j++){
                    gear[i][j] = gear[i][j+1];
                }
                gear[i][7] = temp;
            }
        }
    }
    }