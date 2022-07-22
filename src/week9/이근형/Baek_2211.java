package week9.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_2211 {
    static int computer, edges;
    static int[] dist, path;
    static List<Node>[] graph;
    static PriorityQueue<Node> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        computer = Integer.parseInt(st.nextToken());
        edges = Integer.parseInt(st.nextToken());
        graph = new List[computer + 1];

        for(int i = 1; i <= computer; i++) { // 그래프 초기화
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges; i++) { // 그래프에 경로 기록
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        que = new PriorityQueue<>();
        dist = new int[computer + 1]; // index가 노드 번호, 해당 노드로 가는 최소 경로(weight)를 기록
        path = new int[computer + 1]; // index가 출발점 value가 도착점, 출발점에서 최소 경로로 갈 수 있는 도착점을 기록
        Arrays.fill(dist, Integer.MAX_VALUE); // dist 초기화


        que.offer(new Node(1, 0));
        dist[1] = 0;
        path[1] = -1;


        while(!que.isEmpty()) {
            Node curn = que.poll();

            // 현재 curn으로 가는 경로의 weight가 기존에 기록한 curn으로 가는 경로의 weight보다 큰 경우
            if(curn.weight > dist[curn.node]) continue;

            for(Node next : graph[curn.node]) {
                if(dist[next.node] > curn.weight + next.weight) {
                    path[next.node] = curn.node;
                    dist[next.node] = curn.weight + next.weight;
                    que.offer(new Node(next.node, dist[next.node]));
                }
            }
        }

        StringBuilder result = new StringBuilder();
        // 최소 경로의 수는 computer - 1개  ex) 노드가 3개면 최소 경로는 2개다.
        result.append(computer - 1).append("\n");

        for(int i = 2; i <= computer; i++) {
            result.append(i + " " + path[i] + "\n");
            // i= 출발점, path[i]= 도착점 (양방향이라 순서 상관 없음)
        }
        System.out.println(result);
    }


    static class Node implements Comparable<Node>{
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) { // PriorityQueue를 사용하기 위함
            return this.weight - o.weight;
        }
    }
}
