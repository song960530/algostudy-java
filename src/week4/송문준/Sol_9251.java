package week4.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(lcs(s1, s2));
    }

    private static int lcs(String s1, String s2) {
        int s1Length = s1.length() + 1;
        int s2Length = s2.length() + 1;
        int[][] dp = new int[s1Length][s2Length];


        for (int i = 0; i < s1Length; i++) {
            for (int j = 0; j < s2Length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
