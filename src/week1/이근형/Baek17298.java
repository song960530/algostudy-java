package week1.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] intArray = new int[n];

        String[] candidate = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            intArray[i] = Integer.parseInt(candidate[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && intArray[stack.peek()] < intArray[i]) {
                intArray[stack.pop()] = intArray[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            intArray[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int num : intArray) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
