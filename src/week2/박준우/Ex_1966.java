package baekjoon;
/*
    백준 큐/덱
    1966 프린터 큐
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Ex_1966 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            Queue<Task> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int total = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            ArrayList<Integer> priorities = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < total; j++) {
                int p = Integer.parseInt(st.nextToken());
                int n = j;
                //priorities.add(Integer.parseInt(st.nextToken()));
                queue.add(new Task(p, n));
            }


            int count = 0;
            boolean flag = true;
            while(flag) {
                if(check(queue)) {
                    if(queue.peek().getOrder() == target) {
                        System.out.println(++count);
                        flag = false;
                    } else {
                        Task done = queue.poll();
                        count++;
                    }
                } else {
                    while(!check(queue)) {
                        queue.add(queue.poll());
                    }
                }
            }

        }
    }


    public static boolean check(Queue<Task> queue) {
        if(queue.size() == 1) return true;

        int head = queue.peek().getPriority();
        for(Task t : queue) {
            int curr = t.getPriority();
            if(curr > head) return false;
        }
        return true;
    }

    /*

        for(int i=0; i<t; i++) {
            LinkedList<Task> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int total = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            ArrayList<Integer> priorities = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<total; j++) {
                int p = Integer.parseInt(st.nextToken());
                int n = j;
                //priorities.add(Integer.parseInt(st.nextToken()));
                queue.add(new Task(p, n));
            }


            Collections.sort(queue);


        }
    }

     */

    private static class Task implements Comparable<Task> {
        Integer order;
        Integer priority;

        public Task(Integer priority, Integer order) {
            this.priority = priority;
            this.order = order;
        }

        public Integer getPriority() {
            return priority;
        }

        public void setPriority(Integer priority) {
            this.priority = priority;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }

        public String toString() {
            return  "o:"+this.order+" p:"+this.priority;
        }

        @Override
        public int compareTo(Task t) {
            if(getPriority() == null || t.getPriority() == null) {
                return 0;
            }
            return getPriority().compareTo(t.getPriority())*-1;
        }
    }

}
