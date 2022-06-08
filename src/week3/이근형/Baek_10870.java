package week3.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_10870 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bf.readLine());

        System.out.println(fibonacci(k));
    }

    public static int fibonacci(int k) {

        if(k == 0) return 0;
        if(k == 1 || k == 2) return 1;

        return fibonacci(k - 1) + fibonacci(k - 2);
    }
}
