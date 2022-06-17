package week4.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sol_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[][] sums = new int[cnt][cnt];
        int max = 0;

        for (int i = 0; i < cnt; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < nums.length; j++) {
                if (nums.length == 1) {
                    sums[0][0] = nums[j]; // 최초일때 인덱스 오류 안나게
                } else {
                    int left = j > 0 ? sums[i - 1][j - 1] : 0; // 제일 좌측일경우 0
                    int right = j <= i ? sums[i - 1][j] : 0; // 제일 우측일경우 0
                    sums[i][j] = nums[j] + (left > right ? left : right);
                }
                max = max < sums[i][j] ? sums[i][j] : max;
            }
        }

        System.out.println(max);
    }
}

