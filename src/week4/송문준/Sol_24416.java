package week4.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_24416 {
    static int cnt1 = 0;
    static int cnt2 = 0;
    static int result[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input = Integer.parseInt(br.readLine());
        result = new int[input];

        fib(input);
        fibForDP(input);
        System.out.println(cnt1 + " " + cnt2);
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt1++;
            return 1;
        }

        return (fib(n - 1) + fib(n - 2));
    }

    public static int fibForDP(int n) {
        result[0] = result[1] = 1;

        for (int i = 2; i < n; i++) {
            cnt2++;
            result[i] = result[i - 1] + result[i - 2];
        }

        return result[n - 1];
    }
}
