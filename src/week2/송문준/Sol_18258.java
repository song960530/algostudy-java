package week2.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Sol_18258 {
    public static void main(String[] args) throws IOException {
        CustomQueue<Integer> customQueue = new CustomQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push":
                    customQueue.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    Integer pop = customQueue.pop();
                    sb.append((pop == null ? -1 : pop) + "\n");
                    break;
                case "size":
                    sb.append(customQueue.size() + "\n");
                    break;
                case "empty":
                    sb.append(customQueue.empty() + "\n");
                    break;
                case "front":
                    Integer front = customQueue.front();
                    sb.append((front == null ? -1 : front) + "\n");
                    break;
                case "back":
                    Integer back = customQueue.back();
                    sb.append((back == null ? -1 : back) + "\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}

class CustomQueue<T> {
    private LinkedList<T> list;

    public CustomQueue() {
        list = new LinkedList<>();
    }

    public T push(T t) {
        list.add(t);
        return t;
    }

    public T pop() {
        return list.isEmpty() ? null : list.pop();
    }

    public int size() {
        return list.size();
    }

    public int empty() {
        return list.isEmpty() ? 1 : 0;
    }

    public T front() {
        return list.isEmpty() ? null : list.peek();
    }

    public T back() {
        return list.isEmpty() ? null : list.peekLast();
    }
}