package week4.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sol_12865 {
    /**
     * DP[i][j] = max(DP[i - 1][j], DP[i - 1][j - W[i]] + V[i]);
     * DP[idx(특정 물건을 가리킴)][현재까지 가치합]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 0: 개수, 1: 한도무게
        int[] weight = new int[firstLine[0] + 1];
        int[] value = new int[firstLine[0] + 1];
        int dp[][] = new int[firstLine[0] + 1][firstLine[1] + 1];

        for (int i = 0; i < firstLine[0]; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 0: 무게, 1: 가치
            weight[i + 1] = input[0];
            value[i + 1] = input[1];
        }

        for (int i = 0; i < firstLine[0] + 1; i++) {
            for (int j = 0; j < firstLine[1] + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = j - weight[i] < 0 ? dp[i - 1][j] : Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[firstLine[0]][firstLine[1]]);
    }
}
