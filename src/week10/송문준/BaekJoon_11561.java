package week10.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 못품
public class BaekJoon_11561 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long[] cmd = readLine();

        for (int i = 0; i < cmd[0]; i++) {
            long bridge = readLine()[0]; // 5
            long count = 0;
            long position = 0;
            long nextStep = 1;

            while (true) {
                count++;

                if ((bridge - position) >= (nextStep * 2) + 1) {
                    position += nextStep;
                    nextStep++;
                } else {
                    break;
                }
            }

            System.out.println(count);
        }
    }


    private static long[] readLine() throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    }
}
