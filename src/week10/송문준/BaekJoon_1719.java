package week10.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1719 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Map<Integer, Integer>> queue = new LinkedList<>();
    static Map<Integer, Map<Integer, Integer>> allLinks; // key -> 시작노드, value -> 연결노드,가중치
    static boolean[] visit;
    static Integer[][] route;
    static Integer[][] min;

    public static void main(String[] args) throws IOException {
        // 첫번째줄 read
        int[] cmd = readLine();

        // 배열 초기화
        makeArray(cmd[0]);

        // 경로 및 가중치 저장
        makeLinks(cmd[1]);

        sortAsc();

        for (Map.Entry<Integer, Map<Integer, Integer>> entry : allLinks.entrySet()) {
            Integer startNode = entry.getKey();

            visit = new boolean[cmd[0] + 1];
            queue.offer(entry.getValue());

            boolean first = true;

            while (!queue.isEmpty()) {
                Map<Integer, Integer> map = queue.poll();
                Integer nowNode = findKey(map);

                // 이미 방문했으면 pass
                if (visit[nowNode])
                    continue;

                for (Map.Entry<Integer, Integer> link : map.entrySet()) {
                    Integer endNode = link.getKey();
                    Integer weight = link.getValue();

                    if (startNode == 6 && endNode == 1) {
                        System.out.println();
                    }

                    if (first) {
                        min[startNode][endNode] = weight;
                        route[startNode][endNode] = endNode;
                    } else {
                        if (min[startNode][endNode] == null || min[startNode][endNode] > min[startNode][nowNode] + weight) {
                            min[startNode][endNode] = min[startNode][nowNode] + weight;

                            Integer tmp = nowNode;

                            if(tmp == )
                            route[startNode][endNode] = route[startNode][nowNode];
                        }
                    }

                    queue.offer(allLinks.get(endNode));
                }

                first = false;

                // 방문 헀으니 true
                visit[nowNode] = true;
            }

        }
        wrapUp();

        System.out.println(print());
    }

    private static String print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < route.length; i++) {
            for (int j = 1; j < route[i].length; j++) {
                sb.append((route[i][j] != null ? route[i][j] : "-") + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private static void sortAsc() {
        for (Map<Integer, Integer> value : allLinks.values()) {

        }
    }

    private static void wrapUp() {
        for (int i = 0; i < route.length; i++) {
            route[i][i] = null;
        }
    }

    private static Integer findKey(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Map<Integer, Integer>> entry2 : allLinks.entrySet()) {
            if (entry2.getValue() == map) {
                return entry2.getKey();
            }
        }
        return null;
    }

    private static void makeLinks(int loopCount) throws IOException {
        allLinks = new HashMap<>();

        // 양방향 가중치 연결
        for (int i = 0; i < loopCount; i++) {
            int[] cmd = readLine();

            Map<Integer, Integer> map = allLinks.getOrDefault(cmd[0], new TreeMap<>());
            map.put(cmd[1], cmd[2]);
            allLinks.put(cmd[0], map);

            Map<Integer, Integer> map2 = allLinks.getOrDefault(cmd[1], new TreeMap<>());
            map2.put(cmd[0], cmd[2]);
            allLinks.put(cmd[1], map2);
        }
    }

    private static void makeArray(int nodeCount) {
        route = new Integer[nodeCount + 1][nodeCount + 1];
        min = new Integer[nodeCount + 1][nodeCount + 1];
    }

    private static int[] readLine() throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
