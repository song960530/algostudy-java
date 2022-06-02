package week2.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Sol_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Calc> calcQueue = new LinkedList<>();
        int cmdLine = Integer.parseInt(br.readLine());

        for (int i = 0; i < cmdLine; i++) {
            int cnt = 1;
            int[] countAndIndex = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray(); // [0]:개수, [1]:위치
            int[] priorities = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray(); // 우선순위
            int[] sortPriorities = Arrays.stream(priorities).sorted().toArray();
            calcQueue.clear();

            if (countAndIndex[0] == 1) {
                sb.append(cnt + "\n");
                continue;
            }

            for (int j = 0; j < priorities.length; j++) {
                calcQueue.offer(new Calc(countAndIndex[1] == j ? true : false, priorities[j]));
            }

            for (int k = sortPriorities.length - 1; k > -1; ) {
                if (sortPriorities[k] == calcQueue.peek().getPriority()) {
                    if (calcQueue.peek().isCheck()) {
                        break;
                    } else {
                        calcQueue.poll();
                        cnt++;
                    }
                    k--;
                } else {
                    calcQueue.offer(calcQueue.poll());
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }
}

class Calc {
    private boolean check;
    private int priority;

    public Calc(boolean check, int priority) {
        this.check = check;
        this.priority = priority;
    }

    public boolean isCheck() {
        return check;
    }

    public int getPriority() {
        return priority;
    }
}
