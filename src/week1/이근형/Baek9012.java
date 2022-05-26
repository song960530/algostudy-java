package week1.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < k; i++) {
            String candidate = String.valueOf(bufferedReader.readLine());
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for(int j = 0; j < candidate.length(); j++) {
                if(candidate.charAt(j) == '(') {
                    stack.push(candidate.charAt(j));
                }
                else {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!flag || !stack.isEmpty()) System.out.println("NO");
            else if(flag) System.out.println("YES");
        }
    }
}
