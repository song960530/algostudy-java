package src.week1.박진향;

import java.util.Scanner;
import java.util.Stack;

public class stack1 {

	//백준 10773 제로 문제 
	 public static void main ( String[] args) {
		 
		 Scanner sc = new Scanner(System.in);
		 
		 int input = sc.nextInt();
		 
		 Stack<Integer>  s = new Stack<Integer>();
		 
		 int sum = 0; 
		 
		 for( int i =0 ; i < input ; i++) {
			 
			 int n2 = sc.nextInt();
			 	
			 
			 	if(n2 == 0 ) {
			
				 s.pop();
			 
			 	}else {
				 
				 s.push(n2);
				 
			    }
		 }
		 
		 for(Integer i : s) {
			 sum +=i;
		 }
		 
	 }
}
