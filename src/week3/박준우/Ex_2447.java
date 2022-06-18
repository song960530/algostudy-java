package baekjoon;

import java.io.*;
import java.util.*;

public class Ex_2447 {

    static int n;

    static void input() {
        FastReader scan = new FastReader();
        n = scan.nextInt();
    }

    public static void main(String[] args) {
        input();
        // when n is 27,
        // height = 27, width = 27
        //


    }

    static void recursive(int n) {
        if(n > 3) {

        } else {



        }
    }

    static void normal_line(int n) {
        for(int i = 0; i < i; i++) {
            System.out.print("*");
        }
        System.out.println();
    }



    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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
        Double nextDouble() { return Double.parseDouble(next()); }
    }

}
