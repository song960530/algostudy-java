package week2.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek_5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(bf.readLine());
        Deque<Integer> que = new ArrayDeque<>();
        StringTokenizer st;

        for(int i = 0; i < k; i++) {
            boolean direction = true;
            boolean error = false;
            String[] command = bf.readLine().split("");
            int len = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine(), "[],");

            for(int j = 0; j < len; j++) {
                que.offer(Integer.parseInt(st.nextToken()));
            }

            for(String order : command) {
                switch (order) {
                    case "R":
                        direction = !direction;
                        break;

                    case "D" :
                        if(que.isEmpty()) {
                            error = true;
                        }
                        else if(direction){
                            que.pollFirst();
                        }
                        else if(!direction) {
                            que.pollLast();
                        }
                        break;
                }
            }

            if(error) {
                sb.append("error");
            }
            else if(!error && que.isEmpty()) {
                sb.append("[]");
            }

            if(!que.isEmpty()) {
                if(direction) {
                    sb.append("[");
                    while(!que.isEmpty()) {
                        sb.append(que.pollFirst());
                        if(que.isEmpty()) break;
                        sb.append(",");
                    }
                    sb.append("]");
                }
                else if(!direction) {
                    sb.append("[");
                    while(!que.isEmpty()) {
                        sb.append(que.pollLast());
                        if(que.isEmpty()) break;
                        sb.append(",");
                    }
                    sb.append("]");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
