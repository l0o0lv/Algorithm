import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        
        for(int i = 1 ; i <= testCase ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arrA = new int[Integer.parseInt(st.nextToken())];
            int[] arrB = new int[Integer.parseInt(st.nextToken())];

            st = new StringTokenizer(br.readLine()); //밑에 있는 반복문 안에 넣으면 안된다..
            for(int j = 0 ; j < arrA.length ; j++)
                arrA[j] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int k = 0 ; k < arrB.length ; k++)
                arrB[k] = Integer.parseInt(st.nextToken());

            if(arrA.length < arrB.length)
                System.out.println("#" + i + " " + sumArr(arrA,arrB));
            else
                System.out.println("#" + i + " " + sumArr(arrB,arrA));
            }
        }
    public static int sumArr(int[] smallArr, int[] bigArr){
        int num = 0;
        int answer = 0;
        int limit = bigArr.length - smallArr.length + 1;
                
        for(int a = 0 ; a < limit ; a++){
            int sum = 0;
            for(int b = 0 ; b < smallArr.length ; b++){
                sum += smallArr[b] * bigArr[b+num];
            }
            num++;
            answer = Math.max(sum,answer);
        }
        return answer;
        }
    }