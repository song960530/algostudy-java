package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
    백준 재귀
    11729 하노이 탑 이동 순서
 */
public class Ex_11729 {

    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        hanoi(t, 1, 3, 2);

        System.out.println(count);
        System.out.println(sb);
    }

    public static void move(int t, int begin, int end) {
        sb.append(begin + " " + end + "\n");
        count++;
    }

    public static void hanoi(int t, int begin, int end, int middle) {
        if(t==1) {
            move(1, begin, end);
        } else {
            hanoi(t-1, begin, middle, end);
            move(t, begin, end);
            hanoi(t-1, middle, end, begin);
        }

    }

    public static boolean check(LinkedList<?> list) {
        return list.stream().sorted().collect(Collectors.toList()).equals(list);
    }
}
