package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    백준 DP
    24416 알고리즘 수업 - 피보나치수 1

 */

public class Ex_24416 {

    static int fibRecurCount = 0;
    static int fibDpCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] array = new int[41];
        array[0] = Integer.MAX_VALUE;
        array[1] = array[2] = 1;

        fibRecur(t);
        fibDp(t, array);

        StringBuilder sb = new StringBuilder();
        sb.append(fibRecurCount + " " + fibDpCount);
        System.out.println(sb);

    }

    public static int fibRecur(int n) {
        //System.out.println(n);
        if (n==1 || n == 2){
            fibRecurCount++;
            return 1;
        } else {
            return fibRecur(n-1) + fibRecur(n-2);
        }
    }


    public static void fibDp(int n, int[] array) {
        if( n > 2) {
            for(int i = 3; i <= n; i++) {
                array[i] = array[i-1] + array[i-2];
                fibDpCount++;
            }
        }
    }
}
