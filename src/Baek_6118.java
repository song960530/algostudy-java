import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_6118 {
    // 1에서 출발하는 단일 출발 문제라서 다익스트라 또는 BFS로 푼다.

    static List<List<Integer>> graph; // => 이중 배열로 풀었는데 메모리 초과 나옴
    static int hutgan, gil;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        hutgan = Integer.parseInt(st.nextToken());
        gil = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i <= hutgan; i++) { // graph 초기화
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < gil; i++) { // graph 경로 기록
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        dijkstra(1);
    }

    static void dijkstra(int start) {
        boolean[] visited = new boolean[hutgan + 1];
        int[] dist = new int[hutgan + 1];

        Arrays.fill(dist, Integer.MAX_VALUE); // dist 초기화
        visited[start] = true;
        dist[start] = 0;

        // 시작점과 연결된 노드들의 거리를 기록
        for(int i = 0; i < graph.get(start).size(); i++) {
            int x = graph.get(start).get(i);
            if(!visited[x]) {
                dist[x] = 1;
            }
        }

        // 각 노드를 시작점으로 연결된 노드의 거리를 기록
        for(int i = 0; i < hutgan - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;

            // 방문하지 않은 노드 중 최소 거 찾기
            for(int j = 1; j <= hutgan; j++) {
                if(!visited[j] && dist[j] != Integer.MAX_VALUE) {
                    if(dist[j] < min) {
                        min = dist[j];
                        minIdx = j;
                    }
                }
            }

            // 최소 거리의 노드 방문 처리
            visited[minIdx] = true;

            for(int j = 0; j < graph.get(minIdx).size(); j++) {
                int x = graph.get(minIdx).get(j);
                if(!visited[x]) {
                    if(dist[x] > dist[minIdx] + 1) {
                        dist[x] = dist[minIdx] + 1;
                    }
                }
            }
        }

        int max = -1;
        int maxIdx = -1;
        int maxNum = 1;

        // 최대 값 찾기
        for(int i = 1; i <= hutgan; i++) {
            if(max < dist[i]) {
                max = dist[i];
                maxIdx = i;
                maxNum = 1;
            }
            else if(max == dist[i]) {
                maxNum ++;
            }
        }

        System.out.println(maxIdx + " " + max + " " + maxNum);
    }
}
