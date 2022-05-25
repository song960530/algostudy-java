package week1.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Sol_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String[] result = new String[cnt];

        for (int i = 0; i < cnt; i++) {
            String input = br.readLine();

            if (chkVPS(input))
                result[i] = "YES";
            else
                result[i] = "NO";
        }

        Arrays.stream(result).forEach(System.out::println);
    }

    private static boolean chkVPS(String input) {
        Stack<Character> stack = new Stack<>();

        if (input.length() % 2 != 0 || input.startsWith(")")) {
            return false;
        }

        for (int j = 0; j < input.length(); j++) {
            if (input.charAt(j) == '(') {
                stack.push('(');
            } else {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }

        if (stack.empty()) {
            return true;
        } else
            return false;
    }
}