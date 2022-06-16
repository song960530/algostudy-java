package week4.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1932 {
    static int n;
    static int[][] candidate;
    static Integer[][] dp;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        candidate = new int[n][n];
        dp = new Integer[n][n];

        for(int i = 0; i < n; i++) { // 입력값을 이용하여 이중배열을 생성한다.
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < i + 1; j++) {
                candidate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 생성된 이중배열의 가장 바닥부터 위로 이동하는 방식으로 최대 합을 계산한다.
        // 그러므로 우선 dp(답이 담길 이중배열)에 가장 바닥에 있는 요소를 넣는다.
        for(int i = 0; i < n; i++) {
            dp[n - 1][i] = candidate[n-1][i];
        }
        System.out.println(track(0, 0));
    }

    static int track(int row, int col) {
        // 가장 바닥에 위치한 요소를 탐색하는 경우
        if(row == n - 1) return dp[row][col];

        if(dp[row][col] == null) {
            // 왼쪽 대각선 또는 오른쪽 대각선에 아래 위치한 값 중 가장 큰 값을 고른다.
            // 그리고 현재 위치의 값을 합친다.
            // 이런식으로 계속 중첩하여 최대 합을 구한다.
            dp[row][col] = Math.max(track(row + 1, col), track(row + 1, col + 1))
                    + candidate[row][col];
        }
        return dp[row][col];
    }
}


