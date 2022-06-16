package week4.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_9251 {

    static char[] first;
    static char[] second;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = br.readLine().toCharArray();
        second= br.readLine().toCharArray();
        dp = new Integer[first.length][second.length];

        System.out.println(LCS(first.length - 1, second.length - 1));
    }

    static int LCS(int x, int y) {
        if(x == -1 || y == -1) return 0;

        if(dp[x][y] == null) {
            dp[x][y] = 0;

            if(first[x] == second[y]) {
                dp[x][y] = LCS(x - 1, y - 1) + 1;
            }
            else {
                dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
            }
        }
        return dp[x][y];
    }
}
