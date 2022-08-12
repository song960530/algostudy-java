package week10.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_2792 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int left = 1, right = 0, sum = 0, mid = 0, answer = 0;
        int[] jewel;
        int[] cmd = readLine();

        int studentCount = cmd[0]; // 학생수 -> 5
        int jewelCount = cmd[1]; // 보석 종류 -> 2

        jewel = new int[jewelCount]; // 보석 개수 저장 배열

        // 보석 개수 저장
        right = recordAndGetMaxJewel(right, jewel, jewelCount);

        // 이분탐색
        answer = binarySearch(left, right, answer, jewel, studentCount);

        System.out.println(answer);
    }

    private static int binarySearch(int left, int right, int answer, int[] jewel, int N) {
        int mid;
        int sum;
        while (left <= right) {
            sum = 0;
            mid = (left + right) / 2;

            for (int count : jewel) {
                sum += count / mid;
                if (count % mid != 0)
                    sum++;
            }

            if (sum > N) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }

    private static int recordAndGetMaxJewel(int right, int[] jewel, int M) throws IOException {
        for (int i = 0; i < M; i++) {
            int[] count = readLine();
            jewel[i] = count[0];

            right = jewel[i] > right ? jewel[i] : right;
        }
        return right;
    }

    private static int[] readLine() throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
