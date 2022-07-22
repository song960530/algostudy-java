package week9.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 이거 못풀었음..!!!!!!!!!!!!!!!!!!!!!!
public class BaekJoon_2211 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 첫번째줄 read
        int[] cmd = readLine();

        // 개수만큼 node 생성
        List<Node> nodes = makeNodes(cmd[0]);

        // 입력받아 각 노드별 연결 및 이동 cost 저장
        linkEachNode(cmd[1], nodes);


        Queue<Node> queue = new LinkedList<>();

        for (Node node : nodes) {
            queue.offer(node);
            floyd(queue); // 플로이드 알고리즘 실행
        }

        allClear(nodes);

        System.out.println(printLink(nodes));
    }

    private static String printLink(List<Node> nodes) {
        int count = 0;
        StringBuffer sb = new StringBuffer();

        for (Node node : nodes) {
            node.changeVisited();

            for (Node link : node.getLinked()) {
                if (link.isVisited())
                    continue;
                count++;
                sb.append(node.getIdx() + " " + link.getIdx() + "\n");
            }
        }

        sb.insert(0, count + "\n");

        return sb.toString();
    }

    private static void allClear(List<Node> nodes) {
        for (Node node : nodes) {
            node.changeVisited();
        }
    }

    private static void floyd(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.isVisited()) // 방문 이력이 있으면 pass
                continue;

            poll.changeVisited(); // visited를 -> true로 변경

            for (Iterator<Node> iter = poll.getLinked().iterator(); iter.hasNext(); ) {
                Node link = iter.next();

                if (!link.isVisited()) { // 연결된 노드중 방문 흔적이 있으면 pass
                    int pollCostSum = poll.getCostSum();
                    int linkCostSum = link.getCostSum();
                    int moveCost = poll.getCostMap().get(link);
                    int costSum;

                    if (linkCostSum == 0) { // 최초 계산일때
                        costSum = pollCostSum + moveCost;
                        link.changeNowLinkedNode(poll); // 연결된 노드 저장
                    } else if (pollCostSum + moveCost < linkCostSum) { // 기존값 > 계산된 값
                        costSum = pollCostSum + moveCost;
                        link.removeAssociation(link.getNowLinkedNode());
                        link.changeNowLinkedNode(poll);
                    } else { // 기존값 < 계산된 값
                        costSum = linkCostSum;
                        poll.removeAssociation(link);
                        iter.remove(); // ConcurrentModificationException 때문에 List에서 직접 삭제하지 않고 iter에서 삭제
                    }

                    link.setCostSum(costSum);
                    queue.offer(link);
                }
            }
        }
    }

    private static void linkEachNode(int count, List<Node> nodes) throws IOException {
        for (int i = 0; i < count; i++) {
            int[] input = readLine();
            nodes.get(input[0] - 1).addLink(nodes.get(input[1] - 1));
            nodes.get(input[0] - 1).addCost(nodes.get(input[1] - 1), input[2]);

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
        private int costSum;
        private boolean visited;
        private List<Node> linked;
        private Map<Node, Integer> costMap;
        private Node nowLinkedNode;


        public Node(int idx) {
            this.idx = idx;
            this.costSum = 0;
            this.visited = false;
            this.linked = new LinkedList<>();
            this.costMap = new HashMap<>();
        }

        public int getIdx() {
            return idx;
        }

        public Node getNowLinkedNode() {
            return nowLinkedNode;
        }

        public int getCostSum() {
            return costSum;
        }

        public boolean isVisited() {
            return visited;
        }

        public Map<Node, Integer> getCostMap() {
            return costMap;
        }

        public List<Node> getLinked() {
            return this.linked;
        }

        public void changeNowLinkedNode(Node node) {
            this.nowLinkedNode = node;
        }

        public void addLink(Node node) {
            if (!this.linked.contains(node)) {
                this.linked.add(node);
                node.getLinked().add(this);
            }
        }

        public void addCost(Node node, int cost) {
            this.costMap.put(node, cost);
            node.getCostMap().put(this, cost);
        }

        public void changeVisited() {
            visited = !visited;
        }

        public void setCostSum(int costSum) {
            this.costSum = costSum;
        }

        public void removeAssociation(Node node) {
            if (node == this.nowLinkedNode) {
                this.linked.remove(node);
            }
            node.getLinked().remove(this);
        }
    }
}