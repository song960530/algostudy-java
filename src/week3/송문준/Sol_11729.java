package week3.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_11729 {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        move(n, 1, 3);
        sb.insert(0, cnt + "\n");

        System.out.println(sb);
    }

    public static void move(int no, int start, int from) { // 원판번호, 시작기둥, 목표기둥
        if (no > 1)
            move(no - 1, start, 6 - start - from); // 원판번호, 시작기둥, 중간기둥

        sb.append(start + " " + from + "\n");
        cnt++;

        if (no > 1)
            move(no - 1, 6 - start - from, from);
    }
}
