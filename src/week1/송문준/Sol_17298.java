package week1.송문준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sol_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        int cnt = Integer.parseInt(br.readLine());
        int max, max2, me;
        String[] s = br.readLine().split(" ");
        int[] result = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            stack.push(Integer.parseInt(s[i]));
        }

        for (int i = 0; i < cnt; i++) {
            tmp = (Stack<Integer>) stack.clone();
            max = 0;
            max2 = 0;
            me = 0;

            if (i == 0) {
                result[i] = -1;
                continue;
            }

            for (int j = 0; j < i + 1; j++) {
                int pop = tmp.pop();
                if (max < pop) {
                    max = pop;
                } else {
                    max2 = max2 > pop ? max2 : pop;
                }
                if (j == i) {
                    me = pop;
                }
            }

            if (me < max2) {
                result[i] = max2;
            } else if (me < max) {
                result[i] = max;
            } else {
                result[i] = -1;
            }
        }

        for (int i = cnt - 1; i > -1; i--) {
            System.out.print(result[i]);
            if (i != 0)
                System.out.print(" ");
        }
        System.out.println();
    }
}
