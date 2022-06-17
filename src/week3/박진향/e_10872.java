package week3.박진향;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class e_10872 {

       public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());

            int sum = factorial(N);
            System.out.println(sum);

        }

        public static int factorial(int N) {
            if(N <= 1)
                return 1;	// 종료
            return N * factorial(N - 1);
        }

}
