package week2.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bf.readLine());
        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i <= k; i++) {
            que.offer(i);
        }

        for(int i = 1; i < k; i++) {
            que.poll();
            que.offer(que.poll());
        }

        System.out.println(que.poll());
    }
}
