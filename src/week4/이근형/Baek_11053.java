package week4.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_11053 {
    static int[] candidate;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        candidate = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            candidate[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                if(candidate[j] < candidate[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1; // 이전 숫자보다 한 케이스 더 증가했으므로 1을 증가시킴
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
