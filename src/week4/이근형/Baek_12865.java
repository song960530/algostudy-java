package week4.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_12865 {

    static int[] weight;
    static int[] value;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] order = br.readLine().split(" ");

        int n = Integer.parseInt(order[0]);
        int k = Integer.parseInt(order[1]);

        weight = new int[n];
        value = new int[n];

        for(int i = 0; i < n; i++) {
            String[] item = br.readLine().split(" ");
            weight[i] = Integer.parseInt(item[0]);
            value[i] = Integer.parseInt(item[1]);
        }

        dp = new Integer[n][k + 1];
        System.out.println(dynamic(n - 1, k));
    }

    static int dynamic(int i, int k) {
        if(i < 0) return 0;

        if(dp[i][k] == null) {
            if(weight[i] > k) {
                dp[i][k] = dynamic(i - 1, k);
            }
            else {
                dp[i][k] = Math.max(dynamic(i - 1, k), dynamic(i - 1, k - weight[i]) + value[i]);
            }
        }
        return dp[i][k];
    }

}
