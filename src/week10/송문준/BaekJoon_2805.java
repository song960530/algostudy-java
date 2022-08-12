package week10.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long[] cmd = readLine();
        long[] cmd2 = readLine();
        long result = 0;
        long rangeMin = 0;
        long rangeMax = Arrays.stream(cmd2).max().getAsLong();

        result = binarySearch(cmd[1], cmd2, rangeMin, rangeMax);

        System.out.println(result);
    }

    private static long binarySearch(long height, long[] treeArray, long rangeMin, long rangeMax) {
        long result = 0;
        long beforeSum = Long.MAX_VALUE;

        while (rangeMin <= rangeMax) {
            long mid = calcMid(rangeMin, rangeMax); // mid값 계산
            long sum = calcSum(treeArray, mid); // 자른 나무 계산

            if (sum > height) { // 높이를 더 높게 해줘야하니 좌측 버림
                rangeMin = mid + 1;
            } else { // 높이를 더 낮게 해줘야하니 우측 버림
                rangeMax = mid - 1;
            }

            if (sum >= height && sum <= beforeSum) {
                result = mid;
                beforeSum = sum;
            }
        }

        return result;
    }

    private static long calcSum(long[] treeArray, long mid) {
        return Arrays.stream(treeArray)
                .filter(num -> num - mid > 0)
                .map(num -> num - mid)
                .sum();
    }

    private static long calcMid(long rangeMin, long rangeMax) {
        return ((rangeMax - rangeMin) / 2) + rangeMin;
    }

    private static long[] readLine() throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    }
}
