package week9.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * 5 5
 * 1 3
 * 1 4
 * 4 5
 * 4 3
 * 3 2
 */
public class BaekJoon_1389 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int min = Integer.MAX_VALUE;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        // 첫번째줄 read
        int[] cmd = readLine();

        // 개수만큼 node 생성
        List<Node> nodes = makeNodes(cmd[0]);

        // 입력받아 각 노드별 연결
        linkEachNode(cmd[1], nodes);

        Queue<Node> queue = new LinkedList<>();

        for (Node node : nodes) {
            queue.offer(node);
            floyd(queue); // 플로이드 알고리즘 실행
            updateResult(node.getIdx(), nodes); // 결과값 비교 및 update
            allClear(nodes); // 전체다 돌았으면 다시 false로 변경
        }

        System.out.println(result);
    }

    private static void updateResult(int idx, List<Node> nodes) {
        int sum = 0;
        for (Node n : nodes) {
            sum += n.getCount();
        }

        if (sum < min) {
            min = sum;
            result = idx;
        }
    }

    private static void floyd(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.isVisited()) // 방문 이력이 있으면 pass
                continue;

            poll.changeVisited(); // visited를 -> true로 변경

            for (Node link : poll.getLinked()) {
                if (!link.isVisited()) { // 연결된 노드중 방문 흔적이 있으면 pass
                    int count = link.getCount() == 0 ? poll.getCount() + 1 : poll.getCount() + 1 < link.getCount() ? poll.getCount() + 1 : link.getCount();

                    link.setCount(count);
                    queue.offer(link);
                }
            }
        }
    }

    private static void allClear(List<Node> nodes) {
        for (Node node : nodes) {
            node.changeVisited();
            node.setCount(0);
        }
    }

    private static void linkEachNode(int count, List<Node> nodes) throws IOException {
        for (int i = 0; i < count; i++) {
            int[] input = readLine();
            nodes.get(input[0] - 1).addLink(nodes.get(input[1] - 1));
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
        private int idx;
        private int count;
        private boolean visited;
        private List<Node> linked;

        public Node(int idx) {
            this.idx = idx;
            this.count = 0;
            this.visited = false;
            this.linked = new LinkedList<>();
        }

        public int getIdx() {
            return this.idx;
        }

        public int getCount() {
            return count;
        }

        public boolean isVisited() {
            return visited;
        }

        public List<Node> getLinked() {
            return this.linked;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void changeVisited() {
            visited = !visited;
        }

        public void addLink(Node node) {
            this.linked.add(node);
            node.getLinked().add(this);
        }
    }
}
