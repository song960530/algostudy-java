package baekjoon;

/*
    백준 큐/덱
    덱 10866
 */

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> commands = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        int t = Integer.valueOf(br.readLine());
        for(int i=0; i<t; i++) commands.add(br.readLine());

        for(String s : commands) {
            if(s.equals("empty")) {
                if(deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(s.equals("size")) {
                System.out.println(deque.size());
            } else {
                if(hasParam(s)) {
                    /*
                        handle 'push_{pos} {param}' command
                     */
                    op(s, deque, Integer.valueOf(s.substring(s.indexOf(" ")+1, s.length())));
                } else {
                    if(hasOp(s)) {
                        /*
                            handle 'pop_front', 'pop_back' commands
                         */
                        if(deque.isEmpty()) {
                            System.out.println(-1);
                        } else {
                            int num = op(s, deque);
                            System.out.println(num);
                        }
                    } else {
                        /*
                            handle 'front', 'back' commands
                         */
                        int num;
                        if(deque.isEmpty()) {
                            num = -1;
                        } else {
                            num = isFront(s) ? deque.peek() : deque.peekLast();
                        }
                        System.out.println(num);
                    }
                }
            }

        }
    }

    public static boolean hasParam(String s) {
        return s.contains(" ") ? true : false;
    }

    public static boolean hasOp(String s) {
        return s.contains("_") ? true : false;
    }

    public static boolean isFront(String s) {
        return s.contains("front") ? true : false;
    }

    public static int op(String s, Deque<Integer> deque) {
        // only one case for 'pop'
        // so care about which element will be popped up
        if(deque.isEmpty()) return -1;

        if(isFront(s)){
            return deque.pop();
        } else {
            int last = deque.getLast();
            deque.removeLast();
            return last;
        }
    }

    public static void op(String s, Deque<Integer> deque, int param) {
        // only 'push' case for {param} on front or back
        // so only care about where to put it

        if(isFront(s)) {
            deque.push(param);
        } else {
            deque.addLast(param);
        }
    }


}
