import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= testCase ; i++) {
			System.out.print("#" + i + " ");
			
			List<Integer> list = new ArrayList<>();
			
			String text = br.readLine();
			
			for(int  j = 0 ; j < text.length() ; j++) {
				int number = text.charAt(j) - '0';
				if(!list.contains(number))
					list.add(number);
			}
			System.out.println(list.size());
		}
	}
}