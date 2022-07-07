package week7.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sol_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 줄 read
        int[] commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 노드 개수만큼 그래프 생성
        List<Graph> graphs = createGraphList(commands);

        // 노드끼리 양방향 연결
        for (int i = 0; i < commands[1]; i++) {
            int[] link = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graphs.get(link[0] - 1).addNode(graphs.get(link[1] - 1));
        }

        sortNodes(graphs); // 오름차순 정렬

        dfs(graphs.get(commands[2] - 1));
        System.out.println();

        resetVisited(graphs); // 방문 초기화

        bfs(graphs.get(commands[2] - 1));
        System.out.println();

    }

    private static void bfs(Graph input) {
        Queue<Graph> queue = new LinkedList<>();
        queue.offer(input);

        while (!queue.isEmpty()) {
            Graph graph = queue.poll();

            if (graph.isVisited()) {
                continue;
            } else {
                graph.visit(true);
            }

            System.out.print(graph.getIndex() + " ");

            for (Graph g : graph.getNodes()) {
                queue.offer(g);
            }
        }
    }


    private static void dfs(Graph graph) {
        if (graph.isVisited())
            return;

        graph.visit(true);

        System.out.print(graph.getIndex() + " ");

        for (Graph one : graph.getNodes()) {
            dfs(one);
        }
    }

    private static void resetVisited(List<Graph> graphs) {
        for (Graph graph : graphs) {
            graph.visit(false);
        }
    }

    private static void sortNodes(List<Graph> graphs) {
        for (Graph graph : graphs) {
            Collections.sort(graph.getNodes());
        }
    }

    private static List<Graph> createGraphList(int[] commands) {
        return IntStream.iterate(1, i -> i + 1)
                .mapToObj(i -> new Graph(i))
                .limit(commands[0])
                .collect(Collectors.toList());
    }

    static class Graph implements Comparable<Graph> {

        int index;
        boolean visited;
        List<Graph> nodes;

        public Graph(int index) {
            this.index = index;
            this.nodes = new LinkedList<>();
        }

        public void addNode(Graph node) {
            nodes.add(node);
            node.getNodes().add(this);
        }

        public List<Graph> getNodes() {
            return nodes;
        }

        public void visit(boolean b) {
            visited = b;
        }

        public int getIndex() {
            return index;
        }

        public boolean isVisited() {
            return visited;
        }

        @Override
        public int compareTo(Graph o) {
            if (this.index < o.getIndex())
                return -1;
            else if (this.index > o.getIndex())
                return 1;
            return 0;
        }
    }
}
