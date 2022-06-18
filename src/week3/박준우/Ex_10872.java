package baekjoon;

import java.util.*;
import java.io.*;

public class Ex_10872 {

    static int n;

    static void input() {
        FastReader scan = new FastReader();
        n = scan.nextInt();
    }

    public static void main(String[] args) {
        input();

        System.out.println(factorial(n));
    }

    static Integer factorial(Integer i) {
        if(i == 0) { return 1; }
        else if ( i == 1 ) { return 1; }
        else { return i * factorial(i-1); }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() { return Integer.parseInt(next()); }
        Long nextLong() { return Long.parseLong(next()); }
        Double nextDouble() { return Double.parseDouble(next()); }

    }


}
