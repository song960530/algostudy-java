package week2.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_1966 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bf.readLine());

        for(int i = 0; i < k; i++) {
            String[] info = bf.readLine().split(" ");
            String[] candidate = bf.readLine().split(" ");

            int docNum = Integer.parseInt(info[0]);
            int targetIdx = Integer.parseInt(info[1]);

            if(docNum == 1) {
                System.out.println(1);
                continue;
            }

            Queue<Node> que = new LinkedList<>();
            int result = 0;

            for(int j = 0; j < docNum; j++) {
                que.offer(new Node(j, Integer.parseInt(candidate[j])));
            }

            while(!que.isEmpty()) {
                Node curn = que.poll();
                if(que.stream().anyMatch(other -> other.priority > curn.priority)) {
                    que.offer(curn);
                }
                else {
                    result++;
                    if(curn.location == targetIdx) break;
                }
            }

            System.out.println(result);
        }
    }
}

class Node {
    int location;
    int priority;

    public Node(int location, int priority) {
        this.location = location;
        this.priority = priority;
    }
}
