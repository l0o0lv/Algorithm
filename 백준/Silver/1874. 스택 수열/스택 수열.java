import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int findNum = Integer.parseInt(br.readLine());
        int pushNum = 0;
        int findCount = 0;
        ArrayList<String> texts = new ArrayList<>();
        
        Stack<Integer> myStack = new Stack<>();

        while(true){

            if( pushNum == N+1 ||findCount == N )
                break;
            
            if(!myStack.isEmpty() && myStack.peek() == findNum){
                texts.add("-");
                myStack.pop();
                findCount++;
                if(findCount < N){
                    findNum = Integer.parseInt(br.readLine());
                }
            } else{
                myStack.push(++pushNum);
                texts.add("+");
            }
        }

        if(!myStack.isEmpty()){
            System.out.println("NO");
        } else{
            for(String text : texts){
                System.out.println(text);
            }
        }

    }
}