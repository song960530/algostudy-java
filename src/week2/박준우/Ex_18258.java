package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
/*
    백준 큐/덱
    18258   큐2
 */
public class Ex_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        LinkedList<String> commands = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();

        StringBuilder sb = new StringBuilder();


        for(int i=0; i<t; i++) commands.add(br.readLine());

        for(String s : commands) {
            if(s.equals("size")) {
                //System.out.println(deque.size());
                sb.append(deque.size()).append('\n');
            } else if(s.equals("empty")) {
                if(deque.isEmpty()) {
                    //System.out.println(1);
                    sb.append(1).append('\n');
                } else {
                    //System.out.println(0);
                    sb.append(0).append('\n');
                }
            } else if(s.equals("front")) {
                if(deque.isEmpty()) {
                    //System.out.println(-1);
                    sb.append(-1).append('\n');
                } else {
                    //System.out.println(deque.getLast());
                    sb.append(deque.peek()).append('\n');
                }
            } else if(s.equals("back")) {
                if(deque.isEmpty()) {
                    //System.out.println(-1);
                    sb.append(-1).append('\n');
                } else {
                    //System.out.println(deque.getFirst());
                    sb.append(deque.peekLast()).append('\n');

                }
            } else if(s.equals("pop")) {
                if(deque.isEmpty()) {
                    //System.out.println(-1);
                    sb.append(-1).append('\n');

                } else {
                    //System.out.println(deque.pop());
                    sb.append(deque.pop()).append('\n');

                }
            } else if(s.startsWith("push")) {
                int param = Integer.valueOf(s.substring(s.indexOf(" ")+1, s.length()));
                deque.offer(param);
            }
        }
        System.out.println(sb);
    }
}
