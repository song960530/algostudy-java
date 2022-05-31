package week2.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Sol_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int cnt = Integer.parseInt(br.readLine());
        int size;
        String cmds, input;
        Deque<Integer> queue;

        for (int i = 0; i < cnt; i++) {
            cmds = br.readLine();
            size = Integer.parseInt(br.readLine());
            input = br.readLine();
            if (size == 0) {
                if (cmds.contains("D"))
                    sb.append("error\n");
                else
                    sb.append("[]\n");
                continue;
            }
            queue = Arrays.stream(input.substring(1, input.length() - 1).split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toCollection(LinkedList::new));

            if (cmds.replaceAll("R", "").length() > queue.size()) {
                sb.append("error\n");
                continue;
            }

            boolean reverse = false;

            for (int j = 0; j < cmds.length(); j++) {
                char cmd = cmds.charAt(j);

                switch (cmd) {
                    case 'R':
                        if (reverse) {
//                            queue = queue.stream().sorted().collect(Collectors.toCollection(LinkedList::new));
                            reverse = false;
                        } else {
//                            queue = queue.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(LinkedList::new));
                            reverse = true;
                        }
                        break;
                    case 'D':
                        if (reverse) {
                            queue.pollLast();
                        } else {
                            queue.pollFirst();
                        }
                        break;
                }
            }

            sb.append("[");
            while (!queue.isEmpty()) {
                if (reverse) {
                    sb.append(queue.pollLast());
                } else {
                    sb.append(queue.pollFirst());
                }

                if (!queue.isEmpty())
                    sb.append(",");
            }
            sb.append("]\n");
        }

        System.out.println(sb);
    }
}
