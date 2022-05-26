package week1.송문준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Sol_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();

        int cnt = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = cnt - 1; i > -1; i--) {
            int num = array[i];

            while (!left.empty()) {
                if (num < left.peek()) {
                    right.push(left.peek());
                    break;
                } else {
                    left.pop();
                }
            }

            if (left.empty()) {
                right.push(-1);
            }

            left.push(num);
        }

        while (!right.empty())
            sb.append(right.pop() + " ");

        System.out.println(sb);
    }
}
