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
 * 7
 * 6
 * 1 2
 * 2 3
 * 1 5
 * 5 2
 * 5 6
 * 4 7
 */
public class BaekJoon_2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Queue<Node> queue = new LinkedList<>();

        // 첫번째줄 read
        int[] cmd = readLine();

        // 개수만큼 node 생성
        List<Node> nodes = makeNodes(cmd[0]);

        // 두번째줄 read
        cmd = readLine();

        // 입력받아 각 노드별 연결
        linkEachNode(cmd[0], nodes);

        queue.offer(nodes.get(0));
        System.out.println(bfs(queue));
    }

    private static int bfs(Queue<Node> queue) {
        int moveCnt = -1;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.isVisited())
                continue;
            moveCnt++;

            poll.changeVisited();

            for (Node link : poll.getLinked()) {
                queue.offer(link);
            }
        }

        return moveCnt;
    }

    private static void linkEachNode(int count, List<Node> nodes) throws IOException {
        for (int i = 0; i < count; i++) {
            int[] input = readLine();
            nodes.get(input[0] - 1).addLink(nodes.get(input[1] - 1));

        }
    }

    private static int[] readLine() throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static List<Node> makeNodes(int count) {
        return IntStream.iterate(1, i -> i + 1)
                .mapToObj(i -> new Node(i))
                .limit(count)
                .collect(Collectors.toList());
    }

    static class Node {
        private int idx;
        private boolean visited;
        private List<Node> linked;

        public Node(int idx) {
            this.idx = idx;
            linked = new LinkedList<>();
        }

        public boolean isVisited() {
            return visited;
        }

        public void addLink(Node node) {
            if (!this.linked.contains(node)) {
                this.linked.add(node);
                node.getLinked().add(this);
            }
        }

        public void changeVisited() {
            visited = !visited;
        }

        public List<Node> getLinked() {
            return this.linked;
        }
    }
}
