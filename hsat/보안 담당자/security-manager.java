import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String S = sc.nextLine();

        if(N % 2 != 0){
            System.out.println("No");
            return;
        }

        int outCnt =0;

        for(int i = 0 ; i < N ; i++){
            if(S.charAt(i) ==')') outCnt++;
        }

        int needOut = N / 2 - outCnt;
        int diff = 0;

        for(int i = N - 1 ; i >= 0 ; i--){
            if(S.charAt(i) ==')'){
                diff--;
            }
            else if(S.charAt(i) =='('){
                diff++;
            }
            else if(S.charAt(i) == '?'){
                if(needOut > 0){
                    needOut--;
                    diff--;
                }
                else{
                    diff++;
                }
            }

            if(diff > 0){
                System.out.println("No");
                return;
            }
        }

        if(diff == 0){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}