package week1.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sol_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int cnt = Integer.parseInt(br.readLine());
        int num = 0;

        for (int i = 0; i < cnt; i++) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        Integer sum = stack.stream().reduce(0, Integer::sum);

        System.out.println(sum);
    }
}
