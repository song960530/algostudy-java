package baekjoon;

/*
    백준 스택
    제로
 */

import java.util.*;

/*
    백준 스택
    제로
 */

public class Ex_10773 {

    public static int T;
    public static Stack<Integer> stack;
    public static Scanner sc = new Scanner(System.in);

    public static void input() {
        T = sc.nextInt();
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        input();
        System.out.println(calc());
    }

    public static int calc() {

        for(int i=0; i<T; i++) {
            int num = sc.nextInt();
            if(num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        return stack.stream().mapToInt(i -> i.intValue()).sum();
    }
}
