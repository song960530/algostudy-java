package week2.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Sol_10866 {
    public static void main(String[] args) throws IOException {
        CustomDeque<Integer> customDeque = new CustomDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push_front":
                    customDeque.pushFront(Integer.parseInt(input[1]));
                    break;
                case "push_back":
                    customDeque.pushBack(Integer.parseInt(input[1]));
                    break;
                case "pop_front":
                    Integer popFront = customDeque.popFront();
                    sb.append((popFront == null ? -1 : popFront) + "\n");
                    break;
                case "pop_back":
                    Integer popBack = customDeque.popBack();
                    sb.append((popBack == null ? -1 : popBack) + "\n");
                    break;
                case "size":
                    sb.append(customDeque.size() + "\n");
                    break;
                case "empty":
                    sb.append(customDeque.empty() + "\n");
                    break;
                case "front":
                    Integer front = customDeque.front();
                    sb.append((front == null ? -1 : front) + "\n");
                    break;
                case "back":
                    Integer back = customDeque.back();
                    sb.append((back == null ? -1 : back) + "\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}

class CustomDeque<T> {
    private LinkedList<T> list;

    public CustomDeque() {
        list = new LinkedList<>();
    }

    public T pushFront(T t) {
        list.addFirst(t);
        return t;
    }

    public T pushBack(T t) {
        list.add(t);
        return t;
    }

    public T popFront() {
        return list.pollFirst();
    }

    public T popBack() {
        return list.pollLast();
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
