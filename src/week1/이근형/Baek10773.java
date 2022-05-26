package week1.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            if(num == 0) {
                stack.pop();
            }
            else {
                stack.push(num);
            }
        }

        int result = stack.stream().mapToInt(i -> i).sum();
        System.out.println(result);
    }
}
