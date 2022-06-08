package week3.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_10872 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bf.readLine());
        System.out.println(factorial(k));
    }

    public static int factorial(int k) {
        if(k <= 1) return 1;
        return k * factorial(k - 1);
    }
}
