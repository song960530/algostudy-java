package week2.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek_10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bf.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < k; i ++) {
            String[] command = bf.readLine().split(" ");

            switch (command[0]) {
                case "push_back":
                    deque.addLast(Integer.parseInt(command[1]));
                    break;

                case "push_front":
                    deque.addFirst(Integer.parseInt(command[1]));
                    break;

                case "pop_front":
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.pollFirst());
                    break;

                case "pop_back":
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.pollLast());
                    break;

                case "size":
                    System.out.println(deque.size());
                    break;

                case "empty":
                    if(deque.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;

                case "front":
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.peekFirst());
                    break;

                case "back":
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.peekLast());
                    break;

                default:
                    throw new IllegalStateException("wrong command: " + command[0]);
            }
        }
    }
}
