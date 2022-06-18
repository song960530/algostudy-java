package baekjoon;

import java.util.*;
import java.io.*;

public class Ex_10870 {

    static int n;

    static void input() {
        FastReader scan = new FastReader();
        n = scan.nextInt();
    }

    public static void main(String[] args) {
        input();
        System.out.println(recursive(0, 1, n));

    }

    static int recursive(int first, int second, int rec_times) {
        if(rec_times == 0) {
            return first;
        } else {
            return recursive( second, first+second, --rec_times);
        }
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
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
    }

}
