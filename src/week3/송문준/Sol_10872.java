package week3.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(factorial(Integer.parseInt(br.readLine())));

    }

    private static int factorial(int i) {
        if (i == 0) {
            return 1;
        } else {
            return i * factorial(--i);
        }
    }
}
