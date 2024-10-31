import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 1 ; i <= testCase ; i++){
            System.out.println("#" + i);

            int arrSize = Integer.parseInt(br.readLine());
            int[][] arr = new int[arrSize][arrSize];
            int[][] onceRotate = new int[arrSize][arrSize];
            int[][] secondRotate = new int[arrSize][arrSize];
            int[][] thirdRotate = new int[arrSize][arrSize];
            
            for(int j = 0 ; j < arrSize ; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < arrSize ; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int j = 0 ; j < arrSize ; j++){
                int rotateIndex = arrSize - 1;
                for(int k = 0 ; k < arrSize ; k++){
                    onceRotate[j][k] = arr[rotateIndex][j];
                    rotateIndex--;
                }
            }

            for(int j = 0 ; j < arrSize ; j++){
                int rotateIndex = arrSize - 1;
                for(int k = 0 ; k < arrSize ; k++){
                    secondRotate[j][k] = onceRotate[rotateIndex][j];
                    rotateIndex--;
                }
            }

            for(int j = 0 ; j < arrSize ; j++){
                int rotateIndex = arrSize - 1;
                for(int k = 0 ; k < arrSize ; k++){
                    thirdRotate[j][k] = secondRotate[rotateIndex][j];
                    rotateIndex--;
                }
            }

            for(int j = 0 ; j < arrSize ; j++){
                for(int k = 0 ; k < arrSize ; k++){
                    System.out.print(onceRotate[j][k]);
                }
                System.out.print(" ");
                for(int k = 0 ; k < arrSize ; k++){
                    System.out.print(secondRotate[j][k]);
                }
                System.out.print(" ");
                for(int k = 0 ; k < arrSize ; k++){
                    System.out.print(thirdRotate[j][k]);
                }
                System.out.println("");
            }
            
        }
    }
}