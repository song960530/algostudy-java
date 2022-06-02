package week2.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sol_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = Stream.iterate(1, n -> n + 1)
                .limit(Integer.parseInt(br.readLine()))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println(calcLastNum(queue));
    }

    private static int calcLastNum(Queue<Integer> queue) {
        int num;

        while (true) {
            num = queue.poll();

            if (queue.isEmpty()) {
                break;
            }

            queue.offer(queue.poll());
        }

        return num;
    }
}
