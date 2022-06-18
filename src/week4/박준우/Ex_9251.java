package baekjoon;
/*
    백준 DP
    9251 LCS
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Ex_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strA = br.readLine();
        String strB = br.readLine();

        int[][] mem = new int[strA.length()+1][strB.length()+1];

        for(int i=1; i<=strA.length(); i++) {
            for(int j=1; j<=strB.length(); j++) {
                if(strA.charAt(i-1) == strB.charAt(j-1)) {
                    mem[i][j] = mem[i-1][j-1]+1;  //> mem[i-1][j] ? mem[i][j-1]+1 : mem[i-1][j]+1;
                } else {
                    mem[i][j] = mem[i][j-1] > mem[i-1][j] ? mem[i][j-1] : mem[i-1][j];
                }
            }
        }


        /*
        for(int[] nums : mem) {
            for(int i: nums){
                System.out.print(i + " ");
            }
            System.out.println();
        }

        */

        System.out.println(mem[strA.length()][strB.length()]);


    }

    public static int lcs(String A, String B) {
        if(A.length() == 0 || B.length() == 0) return 0;

        if(A.charAt(A.length()-1) == B.charAt(B.length()-1)) {
            return lcs(A.substring(0, A.length()-1), B.substring(0, B.length()-1)) +1;
        } else {
            return lcs(A.substring(0, A.length()-1), B.substring(0, B.length())) > lcs(A.substring(0, A.length()), B.substring(0, B.length()-1))
                    ? lcs(A.substring(0, A.length()-1), B.substring(0, B.length())) +1
                    : lcs(A.substring(0, A.length()), B.substring(0, B.length()-1))+1;
        }
    }
}
