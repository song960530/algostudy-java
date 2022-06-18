package baekjoon;

/*
    백준 DP
    1932 정수 삼각형
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Ex_1932 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        System.out.println(sum(t));
    }

    public static int sum(int t) throws IOException {

        ArrayList<ArrayList<Integer>> layers = new ArrayList<>();

        int[][] triangle = new int[t][t];
        int[][] memo = new int[t][t];


        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;st.hasMoreTokens();j++) {
                int num = Integer.parseInt(st.nextToken());
                if(t == 1) return num;
                triangle[i][j] = num;
                memo[i][j] = num;
            }
        }

        for(int i=t-2; i>=0; i--) {
            for(int j=0; j<t-1; j++){
                //System.out.println(memo[i][j] + memo[i+1][j] + " " + memo[i][j] +  memo[i+1][j+1]);
                memo[i][j] = Math.max( (memo[i][j] + memo[i+1][j]), (memo[i][j] +  memo[i+1][j+1]) );
            }
        }

        /*
        for(int[] list : triangle) {
            for(int i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

        System.out.println();

        for(int[] list : memo) {
            for(int i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

         */


        return memo[0][0];

    }
}
