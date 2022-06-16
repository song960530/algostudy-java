package week4.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_24416 {

    static int countRecursion = 0;
    static int countDp = 0;
    static int[] memoization = new int[50];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder answer = new StringBuilder();

        recursion(n);
        dp(n);

        answer.append(countRecursion)
                .append(" ")
                .append(countDp);

        System.out.println(answer);
    }

    public static int recursion(int n) {
        if (n == 1 || n == 2) {
            countRecursion++;
            return 1;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

    public static int dp(int n) {

        if(n <= 1) return n;
        else if(n == 2) return 1;
        else {
            if(memoization[n] > 0) return memoization[n];
            countDp++;
            memoization[n] = dp(n - 1) + dp(n - 2);
        }
        return memoization[n];
    }
}
