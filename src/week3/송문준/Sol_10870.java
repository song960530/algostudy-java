package week3.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(num));
    }

    private static int fibonacci(int num) {

        if (num == 1) {
            return 1;
        } else if (num == 0) {
            return 0;
        } else {
            return fibonacci(--num) + fibonacci(--num);
        }
    }
}
