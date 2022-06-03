package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
    백준 덱/큐
    2164 카드2
 */
public class Ex_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());

        /*
        1234

        234
        342

        42
        24

        4
         */

        Deque<Integer> deque = new LinkedList<>();

        for(int i=1; i<=t; i++) deque.add(i);

        //System.out.println(recursion(deque).peek());

        while(deque.size()!=1) {
            deque.pop();
            deque.addLast(deque.pop());
        }
        System.out.println(deque.peek());
    }

    public static Deque<Integer> recursion(Deque<Integer> deque) {

        if(deque.size() == 1) {
            return deque;
        } else {
            System.out.println(deque);
            // 4 3 2 1
            deque.pop();
            deque.addLast(deque.pop());
            return recursion(deque);
        }

    }
}
