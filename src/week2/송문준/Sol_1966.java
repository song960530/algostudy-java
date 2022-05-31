package week2.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Sol_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue1 = new LinkedList<>(); // 우선순위
        Queue<Boolean> queue2 = new LinkedList<>(); // true/false
        int input = Integer.parseInt(br.readLine());

        for (int i = 0; i < input; i++) {
            int[] i1 = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray(); // [0]:개수, [1]:위치
            int[] i2 = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray(); // 우선순위
            int[] i3 = Arrays.stream(i2).sorted().toArray();
            queue1.clear();
            queue2.clear();

            for (int i4 = 0; i4 < i2.length; i4++) {
                queue1.offer(i2[i4]); // 우선순위 입력받은거 저장

                if (i4 == i1[1])
                    queue2.offer(true); // 출력을 원하는 위치에만 true
                else
                    queue2.offer(false);
            }

            int cnt = 1;
            for (int i5 = i3.length - 1; i5 > -1; ) {
                if (queue1.peek() == i3[i5]) {
                    if (queue2.peek()) {
                        break;
                    } else {
                        queue1.poll();
                        queue2.poll();
                        cnt++;
                    }
                    i5--;
                } else {
                    queue1.offer(queue1.poll());
                    queue2.offer(queue2.poll());
                }
            }

            System.out.println(cnt);
        }
    }
}
