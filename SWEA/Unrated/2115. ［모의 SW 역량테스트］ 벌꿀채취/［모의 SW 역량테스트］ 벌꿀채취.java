import java.util.*;
import java.io.*;

class Solution {
    static int N, M, C;
    static int[][] honey;
    static int maxMoney;

    static int combination(){
        int result = 0;
        int max1 = 0;
        int max2 = 0;

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j <= N - M ; j++){
                maxMoney = 0;

                getMaxMoney(i, j , 0, 0, 0);

                max1 = maxMoney;

                maxMoney = 0;
                max2 =0;
                for(int j2 = j + M ; j2 <= N - M; j2++){
                    getMaxMoney(i,j2,0,0,0);
                    max2 = Math.max(max2,maxMoney);
                }

                for(int i2 = i + 1; i2 < N ; i2++){
                    for(int j2 = 0 ; j2 <= N - M ; j2++){
                        getMaxMoney(i2,j2,0,0,0);
                        max2 = Math.max(max2,maxMoney);
                    }
                }

                result = Math.max(result, max1 + max2);
            }
        }
        return result;
    }

    static void getMaxMoney(int i, int j, int count, int sum, int benefit){
        if(sum > C) return;
        if(count == M) {
            maxMoney = Math.max(maxMoney, benefit);
            return;
        }

        getMaxMoney(i, j + 1, count + 1, sum + honey[i][j], benefit + (honey[i][j] * honey[i][j]));
        getMaxMoney(i, j + 1, count + 1, sum, benefit);
        
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1 ; tc <= testCase ; tc++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 벌통 크기
            M = Integer.parseInt(st.nextToken()); // 일꾼
            C = Integer.parseInt(st.nextToken()); // 채취할 수 있는 최대 양
            maxMoney = Integer.MIN_VALUE;
            honey = new int[N][N];

            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N ; j++){
                    honey[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#" + tc + " " + combination());
        }
    }
}