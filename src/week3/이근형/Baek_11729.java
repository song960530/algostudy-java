package week3.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_11729 {

    public static int answer = 0;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bf.readLine());

        hannoi(k, 1, 2, 3);
        sb.insert(0, answer + "\n"); // 가장 첫줄에는 움직인 횟수 저장
        System.out.println(sb);

    }

    public static void hannoi(int k, int from, int mid, int to) {
        answer++;

        if(k == 1) {
            sb.append(from + " " + to + "\n");
        }

        else {
            hannoi(k - 1, from, to, mid); // k - 1개의 블럭을 A -> B로 이동
            sb.append(from + " " + to + "\n");
            hannoi(k - 1, mid, from, to);// k - 1개의 블럭을 B -> C로 이
        }
    }
}
