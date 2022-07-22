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
 * 6 7
 * 3 6
 * 4 3
 * 3 2
 * 1 3
 * 1 2
 * 2 4
 * 5 2
 */
public class BaekJoon_6118 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Queue<Node> queue = new LinkedList<>();
        int maxMove;

        // 첫번째줄 read
        int[] cmd = readLine();

        // 개수만큼 node 생성
        List<Node> nodes = makeNodes(cmd[0]);

        // 처음값만 moveCount 0 으로 세팅
        nodes.get(0).setMoveCount(0);

        // 입력받아 각 노드별 연결
        linkEachNode(cmd[1], nodes);

        queue.offer(nodes.get(0));
        maxMove = floyd(queue); // 최대 움직인 move값 추출

        System.out.println(makeResult(nodes, maxMove));
    }

    private static String makeResult(List<Node> nodes, int maxMove) {
        StringBuilder sb = new StringBuilder();
        int minIdx = Integer.MAX_VALUE;
        int sameCnt = 0;

        for (Node node : nodes) {
            if (node.getMoveCount() == maxMove) {
                sameCnt++;
                minIdx = node.getIdx() < minIdx ? node.getIdx() : minIdx;
            }
        }

        return sb.append(minIdx + " " + maxMove + " " + sameCnt).toString();
    }

    private static int floyd(Queue<Node> queue) {
        int maxMove = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.isVisited()) // 방문 이력이 있으면 pass
                continue;

            poll.changeVisited(); // visited를 -> true로 변경

            for (Node link : poll.getLinked()) {
                if (poll.getMoveCount() + 1 < link.getMoveCount()) {
                    link.setMoveCount(poll.getMoveCount() + 1);
                }

                maxMove = link.getMoveCount() > maxMove ? link.getMoveCount() : maxMove;
                queue.offer(link);
            }
        }

        return maxMove;
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
        private boolean visited;
        private int moveCount;
        private List<Node> linked;

        public Node(int idx) {
            this.idx = idx;
            moveCount = Integer.MAX_VALUE;
            linked = new LinkedList<>();
        }

        public int getIdx() {
            return idx;
        }

        public int getMoveCount() {
            return moveCount;
        }

        public void setMoveCount(int moveCount) {
            this.moveCount = moveCount;
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
