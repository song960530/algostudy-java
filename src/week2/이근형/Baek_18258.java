package week2.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(); // 시간 초과를 극복하기 위해서 SB를 사용
        int k = Integer.parseInt(bf.readLine());

        for(int i = 0; i < k; i++) {
            String[] command = bf.readLine().split(" ");

            switch (command[0]) {
                case "push":
                    deque.offer(Integer.parseInt(command[1]));
                    break;

                case "pop":
                    if(deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.poll()).append("\n");;
                    }
                    break;

                case "size":
                    sb.append(deque.size()).append("\n");
                    break;

                case "empty":
                    if(deque.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    if(deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;

                case "back":
                    if(deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
