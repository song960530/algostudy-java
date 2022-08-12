package week10.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaekJoon_10159 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] result;

    public static void main(String[] args) throws IOException {
        Queue<Node> queue = new LinkedList<>();

        // 첫번째줄 read
        int[] cmd = readLine();

        // node 생성
        List<Node> nodes = makeNodes(cmd[0]);

        // 결과담을 배열 초기화
        result = new int[cmd[0] + 1];

        // 두번째줄 read
        cmd = readLine();

        // 링크 연결
        linkEachNode(cmd[0], nodes);

        for (Node node : nodes) {
            // 정방향 노드 탐색
            queue.offer(node);
            bfsLinked(queue);

            tmpVisitClear(nodes);

            // 역방향(반대방향) 노드 탐색
            queue.offer(node);
            bfsTmpLinked(queue);

            recordResult(nodes, node);

            allVisitClear(nodes);
        }

        printResult();
    }

    private static void printResult() {
        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static void recordResult(List<Node> nodes, Node node) {
        int count = nodes.size();
        for (Node node1 : nodes) {
            if (node1.visit) count--;
        }
        result[node.idx] = count;
    }

    private static void bfsTmpLinked(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.tmpVisit)
                continue;

            for (Node linkNode : poll.converseLinked) {
                queue.offer(linkNode);
            }

            poll.tmpVisit = true;
            poll.visit = true;
        }
    }

    private static void bfsLinked(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.tmpVisit)
                continue;

            for (Node linkNode : poll.linked) {
                queue.offer(linkNode);
            }

            poll.tmpVisit = true;
            poll.visit = true;
        }
    }

    private static void tmpVisitClear(List<Node> nodes) {
        nodes.forEach(node -> {
            node.tmpVisit = false;
        });
    }

    private static void allVisitClear(List<Node> nodes) {
        nodes.forEach(node -> {
            node.visit = false;
            node.tmpVisit = false;
        });
    }

    private static void linkEachNode(int count, List<Node> nodes) throws IOException {
        for (int i = 0; i < count; i++) {
            int[] cmd = readLine();

            nodes.get(cmd[0] - 1).linked.add(nodes.get(cmd[1] - 1)); // 정방향 연결
            nodes.get(cmd[1] - 1).converseLinked.add(nodes.get(cmd[0] - 1)); // 반대방향 연결
        }
    }

    private static List<Node> makeNodes(int count) {
        return IntStream.iterate(1, i -> i + 1)
                .mapToObj(i -> new Node(i))
                .limit(count)
                .collect(Collectors.toList());
    }

    private static int[] readLine() throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    static class Node {
        int idx;
        List<Node> linked;
        List<Node> converseLinked;
        boolean visit;
        boolean tmpVisit;

        public Node(int idx) {
            this.idx = idx;
            this.linked = new LinkedList<>();
            this.converseLinked = new LinkedList<>();
        }
    }

}
