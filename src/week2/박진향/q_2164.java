package week2.박진향;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 백준 2164 카드2 */
public class q_2164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt( br.readLine() );

        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while( q.size() > 1) {
            q.poll();	// 맨 앞의 원소 버림
            q.offer(q.poll());	// 맨 앞의 원소를 버림과 동시에 버려진 원소를 맨 뒤에 삽입
        }

        System.out.println(q.poll());	// 마지막으로 남은 원소 출력
    }
}
